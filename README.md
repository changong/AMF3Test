AMF3二进制数据格式Java语言解析demo。

主要使用了flex的两个jar包：
flex-messaging-common.jar
flex-messaging-core.jar

为什么做这个demo？
在手游项目中为了性能优化，需要将xml数据、json数据全部转换为二进制格式，既减少数据容量又提高解析速度。

所以，调研了AMF3数据格式，结论是性能比较差，最终未采用这种方案。
而是，通过自定义二进制数据格式，实现了数据二进制化。
