[toc]

------

## **JAVA IO操作**

### 	字节流: [InputStream](#节点流分类与描述)/[OutputStream](#节点流分类与描述)

> InputStream/OutputStream是字节流的顶层父类 ，他们提供了输入流和输出流的通用API。字节流一般用于读写二进制操作，如图像和声音数据。

1. ##### 输入字节流层次

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
   > 2. void close（）
   >
   >    ```
   >    这个方法用来关闭流，对于过滤流，，把最顶层流关闭则会自顶向下的关闭所流。
   >    ```
   >
   > 3. int available()
   >
   >    ```
   >    返回流中还有多少可读的字节。在读取大块数据前，常用该方法测试。
   >    ```
   >
   > 4. long skip(long n)
   >
   >    跳掉（扔掉）流中指定字节数量的数据
   >
   > 5. 流的回读方法
   >
   >    ```java
   >    //通过以下三个方法可以实现“书签”功能，在支持回读的流上实现一度数据的重复读
   >    boolean markSupported()
   >    //测试打开的流是否支持回读
   >    vode mark(int readlimt)
   >    //标记当前流，并创建大小由readlimt指定的缓冲区。方法的参数指定了将来通过reset（）方法能重复读取的字节
   >    void reset()
   >    //如果mark方法做了标记，则在继续从流中读取一定数量的字节后调用reset方法，将使后续的读操作从标记处开始读数据
   >    ```

   ---

   

2. ##### 输出字节流层次 ==深灰色为节点流，其他为过滤流==

   ![OutputStream](D:\OneDrive\我的JAVA笔记\xmind\OutputStream.PNG)

   > 1. 基本的写方法
   >
   >    ```java
   >    int write(int c)
   >    //向输出流写一个字节
   >    int write(byte[] b)
   >    //像输出流中写一个字节数组
   >    int write(byte[] b,int off.int len)
   >    //将字节数组中 off 和 len 所指的数据块写入输出流
   >    ```
   >
   > 2. void close（）
   >
   >    ```
   >    这个方法用来关闭流，对于过滤流，，把最顶层流关闭则会自顶向下的关闭所流。
   >    ```
   >
   > 3. void flush()
   >
   >    ```
   >    该方法将强制将缓存的输出数据写出去.
   >    有的输出流会把几次输出的数据缓存，然后一次提交，而该方法将这些数据立即写道目的地。
   >    一般在close前可以先flush
   >    ```

---

### 字符流: [InputStreamReader](#节点流分类与描述)/[OutputStreamWriter](#节点流分类与描述)

1. 输入字符流， ==深灰色为节点流，其他为过滤流==

   > ==Reader& Writer== 是java.io 包中两个字符流类的顶层抽象父类。他们定义了在输入输出流中读写==16bit==字符的通用API。字符流可以处理==Unicode== 字符集中的所有字符，而字节流限于处理==ISO-Latin-1==的==8bit==字节，所以应该使用字符流来读写文本类数据。

   ![Reader](D:\OneDrive\我的JAVA笔记\JAVA笔记.assets\Reader.PNG)

   > 1. 基本的读取方法
   >
   >    ```java
   >    int read()
   >    //读取一个字符作为返回值，若-1则表示文件结束
   >    int read(char cbuf[])
   >    //将读入的字符放入一个字符数组中，并返回所读的字符数
   >    int read(char cbuf[],int off.int len)
   >    //读入的字符放入指定位置字符数组中，返回所读的字符数
   >    ```
   >
   > 2. 其他方法
   >
   >    ```java
   >    void close();//关闭流
   >    long skip(long n);//跳过n个字符
   >    boolean markSupported();//测试打开的流是否支持书签
   >    void mark();//标记当前流
   >    void reset()；//返回标签出
   >    boolean ready();测试当前流是否准备好进行读
   >    ```

2. 输出字符流 

   ![Writer](D:\OneDrive\我的JAVA笔记\JAVA笔记.assets\Writer.PNG)

   > 1. 基本的写方法
   >
   >    ```java
   >    int write(int c)//写单个字符
   >    int write(char c)//写字符数组
   >    int write(char c,int off.int len)
   >    //将字节数组中 off 和 len 所指的数据块写入输出流
   >    int write(String str) //写字符串 
   >    int write(String str,int offset,int length)//写字符串的一部分  
   >    ```
   >
   > 2. 其他方法
   >
   >    ```java
   >    void close()//关闭流
   >    void flush()//强行写
   >    ```

3. 字符流和字节流

   > 字节流与字符流主要的区别在于处理的数据类型。
   >
   > Reader/Writer 与 InputStream/OutputStream 具有相类似的API，并且每个核心的输入/输出字节流，都有相应的Reader 和Writer 版本，例如 ：FileInputStream/FileOutputStream 与 FileReader/FileWriter ,PipedInputStream/PipedOutputStream 与 PipedReader/PipedWriter 等

---

### 缓冲流：[BufferedInputStream](#过滤流分类与描述)/[BufferedOutputStream](#过滤流分类与描述)

> ​         前面的字节流和字符流都没有使用缓冲区，这就意味着，每次的读写操作都要交给操作系统来处理。这样的做法可能会对系统的性能造成很大的影响，因为每次访问操作都可能会引发磁盘硬件的读写或网络的访问，这些磁盘硬件读写或网络访问会占用大量的资源，影响效率。缓冲流是一种装饰器类，目的是让原字节流，字符流新增缓冲的功能。常使用**BufferedInputStream**或**BufferedOutputStream**来进行修饰。

### 	数据流：DataOutputStream

> 简单来说就是允许字节流直接操作基本数据类型和字符串。常用DataInputStream或DataoutputStream进行转换。

![程序](D:\OneDrive\我的JAVA笔记\xmind\程序.png)

### 节点流分类与描述

| 类型              | 流类名称                                                     | 描述                             |
| ----------------- | ------------------------------------------------------------ | -------------------------------- |
| Memory（内存I/O） | ByteArrayInputStream<br />ByteArrayOutputStream<br />CharArrayReader<br />CharArrayWriter | 从/向内存数组读写数据            |
| Memory（内存I/O） | StringBufferInputStream<br />StringReader<br />StringWriter  | 从/向内存字符串读写数据          |
| Pipe（管道I/O）   | [PipedInputStream](#管道流)<br />[PipedOutStream](#管道流)<br />[PipedReader](#管道流)<br />[PipedWriter](#管道流) | 实现管道的输入和输出             |
| File（文件I/O）   | [FileInputStream](#文件流)<br />[FileOutputStream](#文件流)<br />[FileReader](#文件流)<br />[FileWriter](#文件流) | 统称为文件流。对文件进行读写操作 |

### [过滤流分类与描述]()	

| 类型                                                      | 流类（字节流/字符流）名称                                    | 描述                                                         |
| --------------------------------------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| Object Serialization<br />（对象I/O）                     | ObjectInputStream<br />ObjectOutputStream                    | 实现对象的输入输出                                           |
| Data Conversion（数据转换）                               | DataInputStream<br />DataOutputStream                        | 按基本数据类型读写数据                                       |
| Printing（打印流）                                        | PrintStream<br />PrintWriter                                 | 包含方便的打印算法，是最简单的输出流                         |
| Buffering<br />（缓存I/O）                                | [BufferedInputStream](#缓存流（过滤流）)<br />[BufferedOutputStream](#缓存流（过滤流）)<br />[BufferedReader](#缓存流（过滤流）)<br />[BufferedWriter](#缓存流（过滤流）) | 在读入或写出时，对数据进行缓存，以减少I/O的次数。缓存流一般比相类似的非缓存流效率高，并且常与其他流一起使用 |
| Filtering（过滤流）                                       | FilterInputStream<br /><br />FilterOutputStream<br />FilterWriter<br />FilterReader | 是抽象类，定义了过滤流的通用方法。这些方法将在数据读写时进行过滤 |
| Concatenation（流链接）                                   | SequenceInputStream                                          | 将多个输入流连成一个输入流                                   |
| Counting（流数据计数）                                    | LineNumberReader<br />LineNumberWriter                       | 在读入数据时进行计数                                         |
| Peeking Ahead（流预读）                                   | PushbackInputStream<br />PushbackReader                      | 通过缓存机制，进行预读                                       |
| Converting between Bytes and Characters（字节与字符转换） | InputStreamReader<br />OutputStreamWriter                    |                                                              |

#### 输入输出流的套接

> 节点流在程序中不是很常用，一般常通过过滤流或者多个流套在一起，利用各种流的特性共同处理数据。套接的多个流构成了一个流链。
>
> 如图，一个文件流为了提高效率，套接了缓存流，最后套接了数据流以实现按基本数据类型的读取操作

#### 输入流链

<img src="D:\OneDrive\我的JAVA笔记\JAVA笔记.assets\输入流链.PNG" alt="输入流链" style="zoom:150%;" />

#### 输出流链

![输出流链](D:\OneDrive\我的JAVA笔记\JAVA笔记.assets\输出流链.PNG)

### 常用输入/输出流类

#### 文件流

> 文件流 为节点流，易理解
>
> 包括四个类：
>
>  - FileInput Stream
>  - FileOutputStream
>  - FileReader
>  - FileWriter
>
> 构造方法：
>
> - `public FileInputStream(String name)`
> - `public FileInputString(File file)`
>
> 程序：文件的复制
>
> ```java
> import java.io.*;
>  public class CopyBytes{
>      public static void main(String[] args) {
>          //创建两个FIle对象
>          File inputfile=new File("farrago.txt");
>          File outputfile=new File("outputfile.txt");
>          //创建文件输入输出流
>          FileOutputStream out =new FileOutputStream(outputfile);
>          FileInputStream in =new FileInputStream(inputfile);
>          int c;
>          //读写文件中的数据
>          while ((c=in.read())!=-1) {
>              out.write(c);
>          }
>          //关闭流
>          in.close();
>          out.close();
>      }
>  }
> ```
>
> 程序：通过文件字符流实现文本文件的复制
>
> ```java
> import java.io.*;
>  public class Copy{
>      public static void main(String[] args) {
>          //创建两个FIle对象
>          File inputfile=new File("farrago.txt");
>          File outputfile=new File("outputfile.txt");   
>          //创建文件字符输入输出流
>          FileReader in =new FileReader(inputfile);
>          FileWriter out =new FileWriter(outputfile);
>          int c;
>          //读写数据
>          while((c=in.read())!=-1){
>              out.write(c);
>          }
>          //关闭流
>          in.close();
>          out.close();
>      }
>  }
> ```

#### 缓存流（过滤流）

> 缓存流包括四个类：
>
> - BufferedInputStream
> - BufferedOutputStream
> - BufferedReader
> - BufferedWriter
>
> 这种流把数据从原始流成块读入，或把数据积累到一个大数据快后再成批写出，通过减少系统资源的读写次数来加快程序的执行。
>
> BufferedOutputStream/BufferedWriter 仅仅只在缓冲区满或者使用flush()方法时才将数据写入目的地；
>
> 构造方法：
>
> - ``public BufferedInputStream (InputStream in)``
> - ``public BufferedInputStream(InputStream,int size)``
>
> BufferedInputStream/BufferedOutputStream 提供InputStream/OutputStream 中定义的方法，若read(),skip(),write()等
>
> ==BufferedReader类中又新增了一个有用的方法，readLine（），该方法读一行字符返回。行的结束标志时换行符或者回车符。==
>
> ==BufferedWriter类中也新增了一个newLine（）方法，该方法写一个行分隔符，分隔符由系统特性 line.separator 指定，可以是'\n'==

#### 管道流

> 管道流可以实现线程间数据的直接传输，线程A可以通过他的输出管道发送消息，线程B把他的输入管道接到A的输出管道即可接收消息。

![管道流](D:\OneDrive\我的JAVA笔记\JAVA笔记.assets\管道流-1590437894350.PNG)

#### 数据流

> 

#### 标准输入输出



### 文件和文件的随机读取

#### 创建File对象

#### 操作File对象

#### 随机存取文件

### 对象的串行化

#### 对象串行化的方法

#### 构造可串行化对象的类

#### 定制串行化

#### 串行化中对信息的保护

#### 串行化注意事项

### JAVA NIO



------

## **JAVA 线程**



----

## **Java网络编程**

### UDP编程

### TCP编程

### HTTP编程

----

## **JAVA 数据库编程**

### 数据库的安装

> 数据库选择MySQL的社区版本
>
> 链接：https://pan.baidu.com/s/1LpslLQRNacW2-m3x6odNnQ
> 　　提取码：e39z 
>
> 安装成功后将根目录下的bin文件夹放入环境变量PATH中；
>
> 然后用管理员模式打开命令行，进入安装目录下的bin文件夹下：
>
> - mysqld --install 安装mysql服务
>
> - mysqld --initialize --console 初始化mysql ，初始化工程中会产生一个随机密码，记住这个密码！
>
> - net start mysql  开启mysql的服务
>
> - 需要修改密码才能与Navicat连接(602266)
>
>   - alter user 'root'@'localhost' identifiled by '这里是密码'
>   - 再次用 mysql -u root -p 验证新密码
>
> - 这里我后来在连接Navicat时会报错（1251），应该是密码有问题：然后查了大佬的blog：
>
>   https://www.cnblogs.com/dmfcjd/p/9019858.html
>
>   - 这里记录一下解决办法
>
>     > Navicat连接不上，总是报错1251；
>     >
>     > 原因是MySQL8.0版本的加密方式和MySQL5.0的不一样，连接会报错。
>     >
>     > 1. *先通过命令行进入mysql的root账户：*
>     >
>     >    ```mysql
>     >    C:\Windows\system32> mysql -uroot -p
>     >    ```
>     >
>     > 2. 输入密码
>     >
>     > 3. 更改加密方式：
>     >
>     > 4. ```mysql
>     >    mysql> ALTER USER 'root'@'localhost' IDENTIFIED BY 'password' PASSWORD EXPIRE NEVER;
>     >    ```
>     >
>     > 5. 更改密码：
>     >
>     >    ```mysql
>     >    mysql> ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'password';
>     >    ```
>     >
>     > 6. 刷新：
>     >
>     >    ```mysql
>     >    mysql> FLUSH PRIVILEGES;
>     >    ```

---

>
>
>#### MySQL常用命令行：
>
>```mysql
>mysql -h主机地址 -u用户名 －p用户密码
>```
>
>```
>mysqladmin -u用户名 -p旧密码 password 新密码 
>```
>
>```mysql
>create database 数据库名；（创建数据库，别忘记末尾的；）
>```
>
>```
>show databases; (显示数据库)
>```
>
>```mysql
>drop database 数据库； （删除数据库）
>```
>
>```
>use 数据库名； （连接数据库）
>mysql> use xhkdb;
>屏幕提示：Database changed
>use 语句可以通告MySQL把db_name数据库作为默认（当前）数据库使用，用于后续语句。该数据库保持为默认数据库，直到语段的结尾，或者直到发布一个不同的USE语句：
>mysql> USE db1;
>mysql> SELECT COUNT(*) FROM mytable;   # selects from db1.mytable
>mysql> USE db2;
>mysql> SELECT COUNT(*) FROM mytable;   # selects from db2.mytable
>```
>
>
>
>```mysql
>mysql> select database();  选择当前数据库
>```
>
>```
>create table <表名> ( <字段名1> <类型1> [,..<字段名n> <类型n>]);
>eg：
>mysql> create table MyClass(
>  > id int(4) not null primary key auto_increment,
>  > name char(20) not null,
>  > sex int(4) not null default '0',
>  > degree double(16,2));
>```
>
>
>
>| 字段名 | 数字类型 | 数据宽度 | 是否为空 | 是否主键    | 自动增加       | 默认值 |
>| ------ | -------- | -------- | -------- | ----------- | -------------- | ------ |
>| id     | int      | 4        | no       | primary key | auto_increment |        |
>| name   | char     | 20       | no       |             |                |        |
>| sex    | int      | 4        | no       |             |                | 0      |
>| degree | double   | 16       | yes      |             |                |        |
>
>```mysql
>drop table <表名>； 删除数据表
>```
>
>```
>insert into <表名> [( <字段名1>[,..<字段名n > ])] values ( 值1 )[, ( 值n )]
>例如：往表 MyClass中插入二条记录, 这二条记录表示：编号为1的名为Tom的成绩为96.45, 编号为2 的名为Joan 的成绩为82.99， 编号为3 的名为Wang 的成绩为96.5。
>mysql> insert into MyClass values(1,'Tom',96.45),(2,'Joan',82.99), (2,'Wang', 96.59);
>```
>
>```mysql
>命令： select <字段1，字段2，...> from < 表名 > where < 表达式 >
>例如：查看表 MyClass 中所有数据
>mysql> select * from MyClass;
>```
>
>```
>例如：查看表 MyClass 中前2行数据
>mysql> select * from MyClass order by id limit 0,2;
>```
>
>```
>delete from 表名 where 表达式
>例如：删除表 MyClass中编号为1 的记录
>mysql> delete from MyClass where id=1;
>```
>
>```
>语法：update 表名 set 字段=新值,… where 条件
>mysql> update MyClass set name='Mary' where id=1;
>```

> ```mysql
> rename table 原表名 to 新表名; 修该表名
> ```

### Navicat的安装

> Navicat 破解版：https://pan.baidu.com/s/1XgLOCz1QVMqRo7Yk5yLQSg#list/path=%2F
>
> 贴上大佬blog：https://www.cnblogs.com/vivih-y/p/11434263.html

### Navicat和MySql的连接

> 左上角点击连接，输入用户，端口 密码即可连接成功。

### JAVA的数据库编程类

> #### JAVA SQL操作类库：
>
> - java.sql.*
> - javax.sql.*       这两个包只是接口类，根据数据库版本和JDBC合理选择
> - 连接字符串样例：
>   - -jdbc:oracle:thin:@127.0.0.1:1521:dbname
>   - -jdbc:mysql://localhost:3306/mydb
>   - -jdbc:sqlserver://localhost:1433;DatabaseName=dsname
>
> #### JAVA连接数据库操作步骤
>
> - 构建连接（搭桥）
>
>   - 注册驱动，寻找材质，Class.forName("········");
>   - 确定对岸目标，建桥 Connection
>
> - 执行操作（派个人过桥，提着篮子，去拿数据）
>
>   - Statement 执行者
>     - 使用executeQuery()执行select语句，返回结果放在ResultSet中
>     - 使用executeUpdate（）执行insert/update/delete操作，返回一个int ，为被修改的行数
>     - 一个Statement对象一次只能执行一个命令
>   - ResultSet 结果集
>     - next()判断是都还有下一条记录
>     - getInt/getString/getDouble/........
>       - 可以按照索引位置，也可以按照列名
>
> - 释放连接（拆桥）
>
>   - connection.close（）;
>
>   ![JDBC](D:\OneDrive\我的JAVA笔记\JAVA笔记.assets\JDBC.PNG)

> ##### 示例项目：
>
> 我们这里用了maven项目,依赖为:

```xml
<dependencies>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.20</version>
        </dependency>
    </dependencies>
```

```java
package use_mysql;
import java.sql.*;
public class SelectTest {
  public static void main(String[] args) {
      //构建JAVA和数据库的桥梁
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      System.out.println("注册驱动成功！");
    } catch (ClassNotFoundException e) {
      System.out.println("注册驱动失败！");
      e.printStackTrace();
      return;
    }
    // 刚开始写String url = "jdbc:mysql://localhost:3306/myjava"就会报错，愿意应该是创建表时的编码问题
    String url =
        "jdbc:mysql://localhost:3306/myjava?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8";
    Connection conn = null;
    try {
      // 构建Java和数据库间的桥梁，URL，用户名，密码
      System.out.println("准备链接");
      conn = DriverManager.getConnection(url, "root", "602266");
      System.out.println("连接成功");
      // 构建数据库执行者
      Statement stmt = conn.createStatement();
      System.out.println("创建Statement成功！");
	  // 执行SQL语句并返回结果到ResultSet
      ResultSet rs = stmt.executeQuery("select BookId,BookName,Price from book order by BookId");
	  // 开始遍历ResultSet数据
      while (rs.next()) {
        System.out.println(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getInt(3));
      }
      rs.close();
      stmt.close();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    } finally {
      try {
        if (null != conn) {
          conn.close();
        }
      } catch (SQLException se) {
        se.printStackTrace();
      }
    }
  }
}

```

```

```

