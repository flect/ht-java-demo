ht-java-tomcat
==============

### 2015/11/10 Herokuトレーニングアンケート

[アンケートリンク](http://www.clicktools.com/survey?iv=3b12ab07b0562e4)  

+ コースアンケートID
  + E639364
+ 担当講師
  + Flect

---

Sample project that use tomcat(webapp-runner) for Heroku training

How to deploy
--------------

### Step1  

Clone app from Github  

```
$ git clone git@github.com:flect/ht-java-tomcat.git
$ cd ht-java-tomcat/
```

### Step2  

Create Heroku application

```
$ heroku create
```

### Step3  

Deploy application
```
$ git push heroku master
```

### Step 4

Visit application

```
$ heroku open
```
