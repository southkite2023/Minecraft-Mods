# Minecraft Mods

Yuashie 的 Minecraft Java 版 Fabric 模组开源项目集合。

首个项目是 **Yuashie Core**（模组 ID：`yuashie_core`）。当前阶段仅搭建基础工程：模组加载入口、日志、客户端隔离及构建流程；尚未加入物品、方块或玩法。

## 开发环境

- JDK **25**（Java 11、17、21 均不适用）
- Minecraft **26.2**
- Fabric Loader **0.19.5**
- Fabric API **0.161.0+26.2**
- Fabric Loom **1.18.1**，Gradle **9.7.1**
- IntelliJ IDEA 或其他支持 Gradle 的 Java IDE

依赖版本统一放在 [gradle.properties](gradle.properties)。本项目沿用 26.2，其他 Minecraft 版本需单独迁移和验证。

## 快速开始

```bash
git clone https://github.com/southkite2023/Minecraft-Mods.git
cd Minecraft-Mods
java -version
./gradlew build
./gradlew :yuashie-core:runClient
```

Windows 使用 `gradlew.bat` 替换 `./gradlew`。IDE 中打开仓库根目录，并将项目 SDK 和 Gradle JVM 都设置为 JDK 25。第一次构建需联网下载 Gradle、Minecraft 和 Fabric 依赖。

生成的模组位于 `mods/yuashie-core/build/libs/`；安装时使用不带 `-sources` 后缀的 JAR，同时安装对应版本的 Fabric Loader 和 Fabric API。

## 仓库结构

```text
Minecraft-Mods/
├── mods/yuashie-core/
│   ├── build.gradle
│   └── src/
│       ├── main/      # 客户端和专用服务器共享的逻辑、模组元数据
│       └── client/    # 渲染、界面等客户端专用逻辑
├── docs/             # 架构及开发说明
├── gradle/wrapper/   # 固定版本的 Gradle Wrapper
└── .github/workflows/build.yml
```

## 自动构建

推送到 main 或提交 Pull Request 时，GitHub Actions 使用 Java 25 构建，并保存 JAR 构建产物。请以 [Actions 的实际结果](https://github.com/southkite2023/Minecraft-Mods/actions)判断是否通过；构建成功不等于已完成游戏内测试。当前没有自动发布版本或部署服务器的步骤。

## 下一步

1. 启动开发客户端，确认日志出现 `Yuashie Core initialized.`。
2. 在本地启动专用服务器，验证共享逻辑不依赖客户端类。
3. 逐项添加物品注册、配置与命令；公共 API 随实际复用需求提取。

架构约定见 [docs/ARCHITECTURE.md](docs/ARCHITECTURE.md)，贡献流程见 [CONTRIBUTING.md](CONTRIBUTING.md)。

## 许可证

本项目原创代码采用 [MIT](LICENSE) 许可证。Gradle Wrapper 等第三方文件保留各自许可证，见 [THIRD_PARTY_NOTICES.md](THIRD_PARTY_NOTICES.md)。

参考：[Fabric 官方 26.2 示例](https://github.com/FabricMC/fabric-example-mod/tree/26.2)、[Fabric 开发文档](https://docs.fabricmc.net/develop/getting-started/project-structure)。
