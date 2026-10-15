# 架构约定

## 模块边界

仓库根目录负责统一依赖版本与聚合构建，每个模组放在 `mods/<mod-name>/` 下，拥有独立的构建文件、模组元数据和 JAR。当前只有 `:yuashie-core`，无需提前引入网络框架、数据库、依赖注入或通用事件总线。

Yuashie Core 的 Java 包为 `cn.yuashie.core`，资源命名空间为 `yuashie_core`。新增注册对象时，所有 ID 使用该命名空间，避免与原版或其他模组冲突。

## 客户端和专用服务器

- `src/main`：两端均可加载。禁止导入 `net.minecraft.client` 或引用本项目的 client 包。
- `src/client`：仅客户端使用，放置渲染、按键、界面。
- 模组元数据将通用入口和客户端入口分别声明，Loom 使用 splitEnvironmentSourceSets 检查代码边界。
- 只有需要修改原版行为时才添加 Mixin；当前没有空的 Mixin 配置。

## 新增功能

按职责添加 `registry`、`config`、`command` 等包，并由通用或客户端入口调用明确的初始化方法。没有实际功能时不建立空的管理类。配置文件应位于 Fabric 提供的配置目录；世界或玩家数据应与其生命周期绑定，不使用全局可变单例代替持久化。

## 新增模组

在 `mods/` 中创建独立工程，在 `settings.gradle` 中 include 并设置 projectDir，随后将其 build/check/clean 加入根任务。更新 CI 的产物路径。每个模组使用独立模组 ID 和包名；当确实依赖 Yuashie Core 时，再配置 Gradle 项目依赖和 fabric.mod.json 运行时依赖。

## 验证与发布

`./gradlew build` 验证编译和打包。客户端及专用服务器启动需要另行测试，不以编译通过代替兼容性验证。版本由根目录 `mod_version` 管理，当前为 alpha 阶段；没有自动发布到 Modrinth、CurseForge 或服务器的任务。

专用服务器开发启动命令：`./gradlew :yuashie-core:runServer`。首次启动会生成 EULA 文件，开发者阅读并接受 Minecraft EULA 后才能继续运行；不要将运行目录或 EULA 接受状态提交到仓库。
