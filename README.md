# booksystem

如果有疑问，通过公众号【贺贺学编程】，私信我

## 环境说明

Java环境是JDK 1.8，数据库用的是mysql8.0.17（用户名=root，密码=root）

## 用户管理

默认在数据库中存在一个**超级管理员**账户(id=123,password=123)

还有一个**普通用户**，普通用户才能借还书哦（id=666，password=666）

该图书管理系统有三种类型的账户

1、超级管理员，在数据库中的类型是2，超级管理员可以修改管理员和普通用户的权限

2、管理员，在数据库中的类型是1

3、普通用户，在数据库中的类型是0，每一个用户注册时默认是普通用户

## 图书管理

普通用户可以对图书进行增删改查操作，以及借还书