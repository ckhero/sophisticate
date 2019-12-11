## Dockerfile
#### CMD
    CMD <shell 命令> 
    CMD ["<可执行文件或命令>","<param1>","<param2>",...] 
    CMD ["<param1>","<param2>",...]  # 该写法是为 ENTRYPOINT 指令指定的程序提供默认参数
    
#### COPY
    COPY [--chown=<user>:<group>] <源路径1>...  <目标路径>
    COPY [--chown=<user>:<group>] ["<源路径1>",...  "<目标路径>"]