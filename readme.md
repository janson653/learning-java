## 仿写mapreduce框架
1. 定义job模型
2. c->s通信模型
3. server端执行client提交过来的job
4. server端分割任务，maptask，shuffle，reducetask

### 步骤
1. netty cs通信demo
2. 抽象单机版job模型
3. 抽象mapreduce变成模型（job，mapper，reduce，task等）
4. 构建engine，串联任务，处理client请求