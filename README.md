# java14
和杨朔组（3人）合并，共七人，分别为：

李岩（账号：indigokiki）

王晗（账号：wanghan7）

李喆

王佳杰（账号：WJJ711）

杨朔 （账号：yangshuo-code）

薛艺（账号：IL-M）

何贤威（账号：uid8888888888）

push、pull的时候请使用命令行（Bash），谢谢。

在任何情况下，你pull了以后做的所有操作都会被认为是最新版的操作，

请再三确认（有没有merge，会不会报错，能不能运行，有没有误操作别人文件）后再add commit push三连

pull后如果出现问题，请立即找到问题代码的书写者、同桌、老师等进行交流，讨论如何解决。

如果pull后自己的文件消失，请右键模块，local history/show history 找到自己pull下来之前的操作

在右边选择自己的代码（只选自己的，别恢复别人的代码），然后按上面中间的箭头按钮恢复

别选上面最左边的箭头，会恢复所有和现在不同的代码，会污染代码

再三强调，选择的时候请只选自己的代码恢复，别选别人的，别污染代码

多沟通，多交流，做到擦好屁股，再push三连，不污染代码，从我做起，感激。


PageHelper很重要的注意事项
    
    PageHelper.startPage(pageNum,pageSize);
    List<xxxx> xxxxlist = xxxxMapper.selectxxxxxx();
    Page<T> page = new Page<>();
    
    page.setRows();//这里放的是你刚mapper.select出来的xxxxlist
    page.setTotal();//这里放的是mapper.countxxxx，也就是数据库中的数据总条目数，
                    //而不是xxxxlist.size()，这样起不了分页的效果！！
                    //前端会检查的你total是否大于10，大于的话可以点下一页，否则不可以


提示：增、改功能报“请求参数错误”的情况，可能的解决方法：各自pojo的成员变量里有Date类型的请注意，可能需要改成Timestamp类型（因为在mysql里，Date类型只包含年月日，Timestamp类型包含年月日+时分秒）。
