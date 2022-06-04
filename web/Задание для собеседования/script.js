
class user{
	constructor(fname, lname, gender, age, mail, pass ){
		this.fname=fname;
		this.lname=lname;
		this.gender=gender;
		this.age=age;
		this.mail=mail;
		this.pass=pass;
	}

 	getInfo(){
 		alert("First Name: " + this.fname +"\n Last Name: " + this.lname + "\n Gender: "+ this.gender + "\n Age: "+ this.age+"\n Email: "+ this.mail+"\n Password: "+this.pass)
 	 }
}

let a=window.innerWidth;
if(a>=750){
	let con=document.getElementById('conteiner');
	con.addClass('conteiner1');
	con.removeClass('cinteiner');}
	
function qwe(){
	let fn=document.getElementById('fn').value;
	let ln=document.getElementById('ln').value;
	let gn=getValue('flag');
	let age=document.getElementById('age').value;
	let mail=document.getElementById('mail').value;
	let pass=document.getElementById('pass').value;
	let pass2=document.getElementById('pass2').value;
	let a= new user(fn,ln,gn,age,mail,pass);
	if((fn)&&(ln)&&(gn)&&(age)&&(mail)&&(pass)){
		if ((pass==pass2)&&(age<=100)&&(age>=10)){
			a.getInfo();}
		else {alert("Passwords or age are not suitable"); 
				return;}}
	else return;
	
}

function getValue(name) {
    let elements = document.getElementsByName(name);
    let len=elements.length;
    for (let i=0; i<len; ++i)
   if (elements[i].checked) return elements[i].value;

}



