const express = require('express')
const fs = require('fs');
const queryString = require('querystring');
const url = require('url');
const app = express();
app.use(express.static('static'));


//Чтение из файла 
let file = fs.readFileSync('data.json', 'utf8');
let jsonObj = JSON.parse(file);

// Форма 


//Сервер
const port =3434;
app.get('/poisk', (req, res) => {
	let parsedUrl = url.parse(req.url);
    let parsedQS = queryString.parse(parsedUrl.query);
    let name = parsedQS.name;
    let isbn = parsedQS.isbn;
    let writer = parsedQS.writer;
    let kod = parsedQS.kod;
    let izd = parsedQS.izd;

	let jsonData = fs.readFileSync('data.json' , 'utf8');
    let jsObj = JSON.parse(jsonData);
    let x=0;
    let answerrows=[];
    let count=-1;

    for(let i=0; i<jsObj.length; i++){
        if(name==jsObj[i].name){
            answerrows[x]=jsObj[i];
            count=jsObj[i].count;
            x++;
        }
    }
    if(count==-1){
        for(let i=0; i<jsObj.length; i++){
            if(isbn==jsObj[i].isbn){
                answerrows[x]=jsObj[i];
                count=jsObj[i].count;
                x++;
            }
        }
    }
    if(count==-1){
        for(let i=0; i<jsObj.length; i++){
            if(writer==jsObj[i].writer){
                answerrows[x]=jsObj[i];
                count=jsObj[i].count;
                x++;
            }
        }
    }
    if(count==-1){
        for(let i=0; i<jsObj.length; i++){
            if(kod==jsObj[i].kod){
                answerrows[x]=jsObj[i];
                count=jsObj[i].count;
                x++;
            }
        }
    }  
    if(count==-1){ 
        for(let i=0; i<jsObj.length; i++){
            if(izd==jsObj[i].izd){
                answerrows[x]=jsObj[i];
                count=jsObj[i].count;
                x++;
            }
        }
    }
    if(count!=-1){
        res.send(JSON.stringify({
                    er: "",
                    res:answerrows
                }))
        
    }
    if(count==-1){
        answerrows[0]={
            name:"Книг с такими",
            writer:"реквизитами",
            count:"не найдено("
        };
        res.send(JSON.stringify({
        er: "",
        res: answerrows
        }))
    }
})
app.get('/del', (req, res) => {
    let parsedUrl = url.parse(req.url);
    let parsedQS = queryString.parse(parsedUrl.query);
    let jsonData = fs.readFileSync('data.json' , 'utf8');
    let jsObj = JSON.parse(jsonData);
    let click = parsedQS.click;

    for(let i=0; i<jsObj.length; i++){
        if(click==jsObj[i].isbn){
            if(jsObj[i].count>0)
                jsObj[i].count--;
        }
    }
    let all = jsonData.substring(0, 0)+JSON.stringify(jsObj);
    fs.writeFileSync('data.json',all, function(error) {
    if(error) throw error;
        console.log("Асинхронная запись файла завершена.");
    });
    let dateOffset = (24*60*60*1000) * 20; 
    let myDate = new Date();
    myDate.setTime(myDate.getTime() + dateOffset);
    let date=myDate.toDateString();
    let lastWord = "Вы успешно взяли книгу, верните ее: " +date;
    res.send(JSON.stringify({
        er: "",
        ans: lastWord
    }))
})
app.get('/return', (req, res) => {
    let parsedUrl = url.parse(req.url);
    let parsedQS = queryString.parse(parsedUrl.query);
    let name1 = parsedQS.name1;
    let isbn1 = parsedQS.isbn1;

    let jsonData = fs.readFileSync('data.json' , 'utf8');
    let jsObj = JSON.parse(jsonData);
    let x=-1;
    for(let i=0; i<jsObj.length; i++){
        if(name1==jsObj[i].name){
            jsObj[i].count++;
            x++;
        }
    }
    if(x==-1){
        for(let i=0; i<jsObj.length; i++){
            if(isbn1==jsObj[i].isbn){
                jsObj[i].count++;
                x++;
            }
        }
    }
    let all = jsonData.substring(0, 0)+JSON.stringify(jsObj);
    fs.writeFileSync('data.json',all, function(error) {
    if(error) throw error;
        console.log("Асинхронная запись файла завершена.");
    });
    if(x==-1){
        res.send(JSON.stringify({
        er: "",
        res: "Проверьте введенные данные"
        }))
    }
    if(x!=-1){
        res.send(JSON.stringify({
        er: "",
        res: "Вы успешно сдали книгу)"
        }))
    }
})
app.get('/newBook', (req, res) => {
    let parsedUrl = url.parse(req.url);
    let parsedQS = queryString.parse(parsedUrl.query);
    let jsonData = fs.readFileSync('data.json' , 'utf8');
    let jsObj = JSON.parse(jsonData);
    let name2 = parsedQS.name2;
    let isbn2 = parsedQS.isbn2;
    let writer2 = parsedQS.writer2;
    let kod2 = parsedQS.kod2;
    let izd2 = parsedQS.izd2;
    let count=parsedQS.count;
    let res1={
        name:name2,
        isbn:isbn2,
        writer:writer2,
        kod:kod2,
        izd:izd2,
        count:count
    };
    let all = jsonData.substring(0, jsonData.length-1)+', '+JSON.stringify(res1)+"]";
    fs.writeFileSync('data.json', all, function(error) {
        if(error) throw error;
        console.log("Асинхронная запись файла завершена.");
    })
    res.send(JSON.stringify({
        er: "",
        res: "Спасибо за новую книгу)"
        }))

})
app.listen(port, () => {
    console.log(`My Web =>  http://localhost:${port}`)
})