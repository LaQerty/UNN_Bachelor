function getValue(name){
    let elements = document.getElementsByName(name);
    let len=elements.length;
    for (let i=0; i<len; i++)
   if (elements[i].checked) return elements[i].value;
}
function qweqwe(){
	let x=getValue('flag');
	if(x=='one'){
	 form1.style.cssText=`display: flex; margin-left:50px;`;
	 fn.style.cssText=`margin-right:5px;`;
	 fn1.style.cssText=`margin-right:5px;`;
	 fn2.style.cssText=`margin-right:5px;`;
	 fn3.style.cssText=`margin-right:5px;`;
	}
	if(x=='two'){
	 form1.style.cssText=`display: inline-block;margin-left:50px;`;
	 fn.style.cssText=`margin-right:1000px;`;
	 fn1.style.cssText=`margin-right:1000px;`;
	 fn2.style.cssText=`margin-right:1000px;`;
	 fn3.style.cssText=`margin-right:1000px;`;
	}
}


