
## Introduction
![summer-rpc](https://raw.githubusercontent.com/wuzhuang5/summer-rpc/master/documents/summerrpclogo.png)

summer-rpc is a high performance, distributed RPC framework.Provides a stable and high performance RPC function.
Features such as "high-performance、distributed、service-registry、load-balancing、service-governance" 
Now, it's already open source, real "out-of-the-box".

summer-rpc 是一个分布式服务框架，提供稳定高性能的RPC远程服务调用功能。拥有"高性能、分布式、注册中心、负载均衡、服务治理"等特性。现已开放源代码，开箱即用。


## Documentation
- [文档](https://github.com/wuzhuang5/summer-rpc/wiki)


## Features

- 1、快速接入：接入步骤非常简洁，两分钟即可上手；
- 2、服务透明：系统完整的封装了底层通信细节，开发时调用远程服务就像调用本地服务，在提供远程调用能力时不损失本地调用的语义简洁性；
- 3、多调用方案：支持 SYNC、ONEWAY、FUTURE、CALLBACK、异步 等方案；
- 4、多通讯方案：支持 TCP 和 HTTP 两种通讯方式进行服务调用；
- 5、多序列化方案：支持 java原生序列化、HESSIAN、PROTOSTUFF、JSON 等方案；
- 6、负载均衡/软负载：提供丰富的负载均衡策略，包括：轮询、随机、LRU、LFU、一致性HASH等；
- 7、注册中心：可选组件，支持服务注册并动态发现；可选择不启用，直接指定服务提供方机器地址通讯；
- 8、服务治理：提供服务治理中心，可在线管理注册的服务信息，如服务锁定、禁用等；
- 9、服务监控：可在线监控服务调用统计信息以及服务健康状况等
- 10、容错：服务提供方集群注册时，某个服务节点不可用时将会自动摘除，同时消费方将会移除失效节点将流量分发到其余节点，提高系统容错能力。
- 11、高兼容性：得益于优良的兼容性与模块化设计，不限制外部框架；除 spring/springboot 环境之外，理论上支持运行在任何Java代码中，甚至main方法直接启动运行；
- 12、泛化调用：服务调用方不依赖服务方提供的API；


## Communication

- [社区交流]()


## Contributing
Contributions are welcome! Open a pull request to fix a bug, or open an [Issue](https://github.com/wuzhuang5/summer-rpc/issues/) to discuss a new feature or change.

欢迎参与项目贡献！比如提交PR修复一个bug，或者新建 [Issue](https://github.com/wuzhuang5/summer-rpc/issues/) 讨论新特性或者变更。


