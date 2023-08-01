# 接口文档


**简介**:接口文档


**HOST**:localhost:8080


**联系人**:大帅


**Version**:v4.0


[TOC]






# niao-controller


## addNiao


**接口地址**:`/niao/addNiao`


**请求方式**:`POST`


**请求数据类型**:`application/json`

**响应数据类型**:`*/*`

**接口描述**:添加嘘嘘日记，记录用户的尿量，压力，是否感染


**请求示例**:


```javascript
{
  "hurt": 0,
  "niao_amount": 0,
  "yali": 0
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|addNiaoRequest|addNiaoRequest|body|true|AddNiaoRequest|AddNiaoRequest|
|&emsp;&emsp;hurt|感染状态0-未感染 1-感染||false|integer(int32)||
|&emsp;&emsp;niao_amount|尿量（ml）||false|number(double)||
|&emsp;&emsp;yali|压力||false|number(double)||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Niao|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|create_time|提交日期|string(date-time)|string(date-time)|
|hurt|感染状态|integer(int32)|integer(int32)|
|id|数据id|integer(int64)|integer(int64)|
|niao_amount|尿量|number(double)|number(double)|
|user_id|当前用户ID|integer(int64)|integer(int64)|
|yali|压力|number(double)|number(double)|


**响应示例**:
```javascript
{
	"create_time": "",
	"hurt": 0,
	"id": 0,
	"niao_amount": 0,
	"user_id": 0,
	"yali": 0
}
```


# user-controller


## getCurrentUser


**接口地址**:`/user/current`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`

**接口描述**:获取当前用户的登录状态，返回当前用户的登录信息


**请求参数**:


暂无


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|User|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|createTime||string(date-time)|string(date-time)|
|gender|性别|integer(int32)|integer(int32)|
|id||integer(int64)|integer(int64)|
|phone||string||
|touXiang|头像|string||
|updateTime||string(date-time)|string(date-time)|
|userAccount||string||
|userPassword||string||
|userStatus||integer(int32)|integer(int32)|
|username||string||


**响应示例**:
```javascript
{
	"createTime": "",
	"gender": 0,
	"id": 0,
	"phone": "",
	"touXiang": "",
	"updateTime": "",
	"userAccount": "",
	"userPassword": "",
	"userStatus": 0,
	"username": ""
}
```


## userLogin


**接口地址**:`/user/login`


**请求方式**:`POST`

**请求数据类型**:`application/json`

**响应数据类型**:`*/*`

**接口描述**:用户登录接口


**请求示例**:


```javascript
{
  "userAccount": "",
  "userPassword": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|userLoginRequest|userLoginRequest|body|true|UserLoginRequest|UserLoginRequest|
|&emsp;&emsp;userAccount|||false|string||
|&emsp;&emsp;userPassword|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|User|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|createTime||string(date-time)|string(date-time)|
|gender||integer(int32)|integer(int32)|
|id||integer(int64)|integer(int64)|
|phone||string||
|touXiang||string||
|updateTime||string(date-time)|string(date-time)|
|userAccount||string||
|userPassword||string||
|userStatus||integer(int32)|integer(int32)|
|username||string||


**响应示例**:
```javascript
{
	"createTime": "",
	"gender": 0,
	"id": 0,
	"phone": "",
	"touXiang": "",
	"updateTime": "",
	"userAccount": "",
	"userPassword": "",
	"userStatus": 0,
	"username": ""
}
```


## userRegister


**接口地址**:`/user/register`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`

**接口描述**:用户注册接口


**请求示例**:


```javascript
{
  "checkPassword": "",
  "userAccount": "",
  "userPassword": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|userRegisterRequest|userRegisterRequest|body|true|UserRegisterRequest|UserRegisterRequest|
|&emsp;&emsp;checkPassword|||false|string||
|&emsp;&emsp;userAccount|||false|string||
|&emsp;&emsp;userPassword|||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK||
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


暂无


**响应示例**:
```javascript

```


# yao-controller


## addYiao


**接口地址**:`/yao/addYao`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`

**接口描述**:添加药品


**请求示例**:


```javascript
{
  "yao_name": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|addYaoRequest|addYaoRequest|body|true|AddYaoRequest|AddYaoRequest|
|&emsp;&emsp;yao_name|药品名称||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|Yao|
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- |
|id||integer(int64)|integer(int64)|
|yao_enddate|*结束用药日期*|string(date-time)|string(date-time)|
|yao_id||integer(int64)|integer(int64)|
|yao_name||string||
|yao_startdate|*开始用药日期*|string(date-time)|string(date-time)|


**响应示例**:
```javascript
{
	"id": 0,
	"yao_enddate": "",
	"yao_id": 0,
	"yao_name": "",
	"yao_startdate": ""
}
```