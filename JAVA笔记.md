[toc]

------

## JAVA IO操作

1. ### **类型：**

- [ ] ​	**字节流:InputStream/OutputStream**

  > InputStream/OutputStream是字节流的顶层父类 ，他们提供了输入流和输出流的通用API。字节流一般用于读写二进制操作，如图像和声音数据。

  1. 输入字节流层次

     `FileInputStream,PipeInputStream,ByteArrayInputStream,StringBuffInputStream 为节点流，其他是过滤流`

     ![InputStream](D:\OneDrive\我的JAVA笔记\xmind\InputStream.PNG)

     > InputStream是输入字节流对象的顶层抽象父类
     >
     > 1. 基本的读取方法
     >
     >    ```java
     >    int read()
     >    //读取一个字节作为返回值，若-1则表示文件结束
     >    int read(byte[] b)
     >    //将读入的数据放入一个字节数组中，并返回所读的字节数
     >    int read(byte[] b,int off.int len)
     >    //读入的数据放入字节数组中，并返回所读的字节数，两个参数表示所读入数据在数组b中的存放位置
     >    ```
     >
     >    
     >
     > 2. void close（）
     >
     >    读一个字节作为返回值，-1表示文件结束
     >
     > 3. int available()
     >
     > 4. long skip(long n)
     >
     > 5. 流的回读方法
     >
     > 6. void mark(int readlimt)

  2. 输出字节流层次 ==深灰色为节点流，其他为过滤流==

     ![OutputStream](D:\OneDrive\我的JAVA笔记\xmind\OutputStream.PNG)

  3. 字节流与字符流

- [ ] 字符流:InputStreamReader/OutputStreamWriter**

  > 字节流转为字符流：将一个字节流转为一个字符流，通常使用InputStreamReader或OutputStreamWriter进行转换。

- [ ] ​	**缓冲流：BufferedInputStream/BufferedOutputStream**

  > ​         前面的字节流和字符流都没有使用缓冲区，这就意味着，每次的读写操作都要交给操作系统来处理。这样的做法可能会对系统的性能造成很大的影响，因为每次访问操作都可能会引发磁盘硬件的读写或网络的访问，这些磁盘硬件读写或网络访问会占用大量的资源，影响效率。缓冲流是一种装饰器类，目的是让原字节流，字符流新增缓冲的功能。常使用**BufferedInputStream**或**BufferedOutputStream**来进行修饰。

- [ ] ​	**数据流：DataOutputStream**

  > 简单来说就是允许字节流直接操作基本数据类型和字符串。常用DataInputStream或DataoutputStream进行转换。

  ![程序](D:\OneDrive\我的JAVA笔记\xmind\程序.png)

------

## JAVA 线程



## Java网络编程

1. UDP编程
2. TCP编程
3. HTTP编程



## JAVA 高级

