
数据脱敏处理
1.可配置化哪些需要进行数据脱敏处理,坚持对已有系统不改动原则,按系统id进行数据脱敏处理规则划分
2.脱敏策略可配置化
3.脱敏算法可配置化
4.对外提供统一数据脱敏和查看原文API,涉及各系统用户查看权限的划分(权限可定制化)

数据识别器，数据脱敏器，需要考虑不同级别的脱敏

rule.json为脱敏规则表
algorithm.json为所有算法表

拦截controller的vo进行脱敏,拦截controller的入参进行解码


