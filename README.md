# xu-picture 云图库

xu-picture 是一个图片分享与管理平台，支持公开图库、私有空间、团队空间三种图库形态，提供图片上传、审核、检索、AI 扩图、空间容量管理、空间分析、多人在线协同编辑等能力。

项目包含两套后端实现：

- 根目录 `src/`：经典分层架构版本（包名 `com.xu.xupicturebackend`）
- `xu-picture-backend-ddd/`：DDD 领域驱动架构版本（包名 `com.xu.xupicture`）

两套后端功能一致，共用同一个 Vue 3 前端（`xu-picture-frontend/`）。

## 目录

- [功能特性](#功能特性)
- [技术栈](#技术栈)
- [项目结构](#项目结构)
- [DDD 分层说明](#ddd-分层说明)
- [快速开始](#快速开始)
- [接口文档](#接口文档)
- [接口测试](#接口测试)
- [配置说明](#配置说明)
- [其他说明](#其他说明)

## 功能特性

### 用户模块

- 用户注册、登录、注销，基于 Spring Session + Redis 实现分布式会话（Cookie 有效期 30 天）
- 基于 Sa-Token 的权限认证，支持 user / admin 两种用户角色
- 管理员用户管理：新增、删除、修改、分页查询用户
- 全局登录校验与权限校验（注解 + AOP 实现）

### 图片模块

- 图片上传：本地文件上传（存储到腾讯云 COS 对象存储）、通过 URL 上传、通过 URL 批量抓取上传（使用 jsoup 解析网页）
- 图片管理：修改、删除、分页查询、批量编辑（批量重命名、批量修改分类与标签等）
- 图片审核：待审核 / 通过 / 拒绝三种状态流转，支持管理员审核
- 图片检索：按名称、简介、分类、标签等基础属性搜索；按图片主色调进行颜色搜索；以图搜图
- 图片加载与存储优化：缩略图生成、Redis + Caffeine 多级缓存
- AI 图片编辑：基于阿里云 AI 接口的 AI 扩图任务创建与结果查询

### 空间模块

- 私有空间与团队空间两种空间类型
- 空间级别：普通版 / 专业版 / 旗舰版，不同级别对应不同的图片数量与容量配额
- 空间成员管理：viewer（浏览者）/ editor（编辑者）/ admin（管理员）三种角色，基于注解实现细粒度权限校验

### 空间分析

- 空间用量分析、分类分布分析、标签分布分析、图片大小分布分析、用户上传分布分析、空间图片排行
- 前端使用 Apache ECharts 与词云图进行可视化展示

### 图片协同编辑

- 基于 WebSocket 的多人实时协同编辑（放大、缩小、左旋、右转等操作实时同步）
- 使用 LMAX Disruptor 无锁队列消费编辑事件，提升并发处理能力

### 分库分表

- 基于 ShardingSphere-JDBC，图片表按 spaceId 动态分表，使用自定义分片算法

## 技术栈

### 后端

| 技术 | 版本 | 说明 |
| --- | --- | --- |
| Spring Boot | 2.7.6 | 基础框架（Web、AOP、WebSocket、Session） |
| MyBatis-Plus | 3.5.9 | ORM 框架，逻辑删除、分页插件 |
| MySQL | 8.x | 关系型数据库 |
| Redis | 6.x+ | 分布式缓存、分布式 Session、Sa-Token 会话存储 |
| Caffeine | 3.1.8 | 本地缓存，与 Redis 组成多级缓存 |
| Sa-Token | 1.39.0 | 权限认证框架（整合 Redis） |
| ShardingSphere-JDBC | 5.2.0 | 分库分表，图片表按 spaceId 动态分表 |
| Knife4j | 4.4.0 | 接口文档（OpenAPI 2 / Swagger） |
| 腾讯云 COS SDK | 5.6.227 | 对象存储，图片文件存储 |
| jsoup | 1.15.3 | HTML 解析，URL 批量抓图 |
| LMAX Disruptor | 3.4.2 | 高性能无锁队列，协同编辑事件处理 |
| Hutool | 5.8.26 | 常用工具库 |
| Lombok | - | 简化实体类代码 |

### 前端

| 技术 | 说明 |
| --- | --- |
| Vue 3 + TypeScript | 前端框架 |
| Vite 6 | 构建工具 |
| Ant Design Vue 4 | 组件库 |
| Pinia | 状态管理 |
| Vue Router 4 | 路由 |
| Axios | HTTP 请求 |
| Apache ECharts 5 + echarts-wordcloud | 空间分析可视化 |
| vue-cropper | 图片编辑 / 裁剪 |
| vue3-colorpicker | 颜色选择（颜色搜索） |
| @umijs/openapi | 根据后端接口文档生成前端请求代码 |

## 项目结构

```
xu-picture-backend
├── src/                                # 后端：经典分层架构版本（包名 com.xu.xupicturebackend）
│   └── main/java/com/xu/xupicturebackend/
│       ├── controller/                 # 接口层：REST 接口
│       ├── service/                    # 业务层：业务逻辑
│       ├── mapper/                     # 数据访问层：MyBatis-Plus Mapper
│       ├── model/                      # 数据模型：entity / dto / vo / enums
│       ├── manager/                    # 通用业务：文件上传、WebSocket、分表、鉴权
│       ├── api/                        # 外部接口：阿里云 AI、以图搜图
│       └── aop/ annotation/ config/ common/ constant/ exception/ utils/
├── xu-picture-backend-ddd/             # 后端：DDD 领域驱动架构版本（包名 com.xu.xupicture）
│   ├── src/main/java/com/xu/xupicture/
│   │   ├── interfaces/                 # 用户接口层：Controller、DTO、VO、Assembler
│   │   ├── application/                # 应用层：应用服务（用例编排）
│   │   ├── domain/                     # 领域层：user / picture / space 三个领域
│   │   ├── infrastructure/             # 基础设施层：Mapper、仓储实现、配置、外部 API
│   │   └── shared/                     # 通用能力：权限认证、分表算法、WebSocket
│   ├── httpTest/                       # 接口测试文件（IntelliJ HTTP Client）
│   └── sql/                            # 数据库初始化脚本
├── xu-picture-frontend/                # 前端：Vue 3 + TypeScript + Vite
│   └── src/
│       ├── pages/                      # 页面：主页、图片详情、搜索、空间、空间分析、管理后台等
│       ├── components/                 # 公共组件
│       ├── api/                        # 接口请求代码（可由接口文档生成）
│       ├── stores/ router/ utils/      # 状态管理、路由、工具
│       └── constants/                  # 枚举与常量
├── sql/create_table.sql                # 数据库初始化脚本
└── httpTest/                           # 接口测试文件（IntelliJ HTTP Client）
```

## DDD 分层说明

`xu-picture-backend-ddd` 模块按领域驱动设计思想分层，调用方向为：
`interfaces -> application -> domain <- infrastructure`。

### interfaces（用户接口层）

- `controller`：接收 HTTP 请求、参数校验、组装统一响应
- `dto` / `vo`：请求参数对象与响应视图对象
- `assembler`：DTO、VO 与领域实体之间的转换

### application（应用层）

- 承担用例编排：用户、图片、空间、空间成员、空间分析五类应用服务
- 调用领域服务与仓储完成业务流程，不包含核心业务规则

### domain（领域层）

- `entity`：领域实体（User、Picture、Space、SpaceUser）
- `valueobject`：值对象与枚举（图片审核状态、空间级别、空间类型、空间角色、用户角色）
- `repository`：仓储接口，仅定义在领域层，由基础设施层实现
- `service`：领域服务，承载跨实体的业务规则

### infrastructure（基础设施层）

- `repository`：仓储实现，基于 MyBatis-Plus Mapper
- `mapper`：数据访问接口与 XML
- `config`：CORS、COS、MyBatis-Plus、JSON 等配置
- `aop`：权限校验切面
- `api`：外部服务封装（腾讯云 COS、阿里云 AI 扩图、以图搜图）
- `manager` / `utils`：文件上传等通用能力与工具类

### shared（通用层）

- `auth`：Sa-Token 权限认证（登录校验、空间成员权限校验、权限上下文）
- `sharding`：自定义分表算法 PictureShardingAlgorithm（按 spaceId 分表）
- `websocket`：协同编辑 WebSocket 服务端与 Disruptor 事件处理

## 快速开始

### 环境要求

- JDK 8 及以上（推荐 JDK 17）
- Maven 3.6+
- MySQL 8.0+
- Redis 6.0+
- Node.js 20+（仅前端需要）

### 1. 初始化数据库

执行 `sql/create_table.sql`，脚本会创建 `xu_picture` 库以及 user、picture、space、space_user 四张表：

```bash
mysql -uroot -p < sql/create_table.sql
```

### 2. 修改后端配置

编辑 `application.yml`（DDD 版本位于 `xu-picture-backend-ddd/src/main/resources/`，经典版本位于 `src/main/resources/`）：

- MySQL 连接：默认 `jdbc:mysql://localhost:3306/xu_picture`，用户名 root / 密码 123456
- Redis 连接：默认 `127.0.0.1:6379`，database 1
- 服务端口：8123，接口前缀：/api

### 3. 配置本地开发密钥

在对应模块的 `src/main/resources/` 下创建 `application-local.yml`（该文件已在 .gitignore 中忽略，不会提交到版本库），填写腾讯云 COS 与阿里云 AI 的配置：

```yaml
# 对象存储配置（需要从腾讯云获取）
cos:
  client:
    host: <COS 访问域名>
    secretId: <腾讯云 SecretId>
    secretKey: <腾讯云 SecretKey>
    region: <所在地域>
    bucket: <存储桶名称>
# 阿里云 AI 配置
aliYunAi:
  apiKey: <阿里云 AI API Key>
```

### 4. 启动后端

任选一个版本启动（两套后端使用相同的端口与数据库，请勿同时启动）：

```bash
# DDD 版本
cd xu-picture-backend-ddd
mvn spring-boot:run

# 经典分层版本
mvn spring-boot:run
```

### 5. 启动前端

```bash
cd xu-picture-frontend
npm install
npm run dev
```

前端默认请求 `http://localhost:8123`，请求时携带 Cookie（withCredentials）。

### 前端常用命令

| 命令 | 说明 |
| --- | --- |
| npm run dev | 启动开发服务器 |
| npm run build | 类型检查并构建生产包 |
| npm run lint | ESLint 检查并修复 |
| npm run format | Prettier 格式化 |
| npm run openapi | 根据后端接口文档生成前端请求代码（需先启动后端） |

## 接口文档

启动后端后可通过 Knife4j 查看接口文档并在线调试：

- 文档页面：http://localhost:8123/api/doc.html
- OpenAPI JSON：http://localhost:8123/api/v2/api-docs

主要接口分组：

| 分组 | 路径前缀 | 说明 |
| --- | --- | --- |
| 用户 | /user | 注册、登录、注销、用户管理 |
| 图片 | /picture | 上传、编辑、审核、检索、批量操作、AI 扩图 |
| 空间 | /space | 空间增删改查、分页查询、级别列表 |
| 空间成员 | /spaceUser | 空间成员的增删改查与列表 |
| 空间分析 | /space/analyze | 用量、分类、标签、大小、用户、排行 |
| 文件 | /file | 文件上传、下载（测试） |
| 健康检查 | /health | 服务健康检查 |

## 接口测试

`httpTest/` 与 `xu-picture-backend-ddd/httpTest/` 目录提供了 IntelliJ HTTP Client 测试脚本：

- `picture.http`：图片模块接口用例（公开图库与空间图片的上传、编辑、权限场景）
- `space_user.http`：空间成员模块接口用例
- `http-client.env.json`：测试环境变量（管理员、空间创建者、编辑者、浏览者等不同角色的 Cookie 与常用 ID）

使用前先通过登录接口获取各角色的 Cookie，并更新到 `http-client.env.json` 中，然后直接运行 .http 文件中的请求。

## 配置说明

- `application-local.yml` 用于保存腾讯云 COS 与阿里云 AI 的密钥，已被 .gitignore 忽略，请勿提交到版本库
- 图片文件存储在腾讯云 COS 对象存储中，服务端本地不保存图片文件
- 图片表按 spaceId 分表，分片算法为自定义类，相关配置位于 `spring.shardingsphere` 下

## 其他说明

- 仓库包含两套后端代码：根目录 `src/`（经典分层，包名 `com.xu.xupicturebackend`）与 `xu-picture-backend-ddd/`（DDD 架构，包名 `com.xu.xupicture`），两者功能一致
- 两套后端默认端口均为 8123，不能同时启动
- 前端部分请求代码通过 `npm run openapi` 从后端 Knife4j 文档生成，修改后端接口后建议重新生成
