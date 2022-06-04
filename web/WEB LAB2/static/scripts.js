function tableCreate(array){
    let body = document.body;
    let tbl  = document.createElement('table');
    tbl.id="table";
    tbl.style.position = 'absolute';
    tbl.style.left= '550px';
    tbl.style.top= '15%';

	let t;
   	let tr=tbl.insertRow();
   	let td1 = tr.insertCell();
   	let td2 = tr.insertCell();
   	let td3 = tr.insertCell();
    td1.appendChild(document.createTextNode('Название'));
    td2.appendChild(document.createTextNode('Автор'));
    td3.appendChild(document.createTextNode('Количество'));
    td3.style.width ='100px';
    for(let i = 0; i < array.length; i++){
        t = tbl.insertRow();
        t.id=i;
        //console.log(t.id);
        for(let j = 0; j < 3; j++){
            let td = t.insertCell();
            if(j==2){
            	td.style.width= '100px'; 
            	td.appendChild(document.createTextNode(array[i].count));
            }
            if(j==1){
            	td.style.width= '300px';
            	td.appendChild(document.createTextNode(array[i].writer));
            }
            if(j==0){
            	td.style.width= '300px';
            	td.appendChild(document.createTextNode(array[i].name));
        	}
        }
    }
    body.appendChild(tbl);
    for(let i=0;i<array.length;i++){
    	let el=document.getElementById(i)
    	el.addEventListener("click", () => {	
    		let click = array[i].isbn;
    		fetch(`/del?click=${click}`, {method: 'GET'})
    		.then(response => response.json())
    		.then(json => {
    			alert(json.ans);
    			table.remove();
    			document.getElementById("name").value="";
				document.getElementById("isbn").value="";
				document.getElementById("writer").value="";
				document.getElementById("kod").value="";
				document.getElementById("izd").value="";
    		})

		})
	}
}
function poisk(){
	let name=document.getElementById("name").value;
	let isbn=document.getElementById("isbn").value;
	let writer=document.getElementById("writer").value;
	let kod=document.getElementById("kod").value;
	let izd=document.getElementById("izd").value;
	fetch(`/poisk?name=${name}&isbn=${isbn}&writer=${writer}&kod=${kod}&izd=${izd}`, {method: 'GET'})
    .then(response => response.json())
    .then(json => {
    	tableCreate(json.res);
    })
}
function add(){
	let name1=document.getElementById("name1").value;
	let isbn1=document.getElementById("isbn1").value;
	fetch(`/return?name1=${name1}&isbn1=${isbn1}`, {method: 'GET'})
    .then(response => response.json())
    .then(json => {
    	alert(json.res);
    	document.getElementById("name1").value="";
		document.getElementById("isbn1").value="";

    })
}
function newBook(){
	let name2=document.getElementById("name2").value;
	let isbn2=document.getElementById("isbn2").value;
	let writer2=document.getElementById("writer2").value;
	let kod2=document.getElementById("kod2").value;
	let izd2=document.getElementById("izd2").value;
	let count=document.getElementById("count").value;
	fetch(`/newBook?name2=${name2}&isbn2=${isbn2}&writer2=${writer2}&kod2=${kod2}&izd2=${izd2}&count=${count}`, {method: 'GET'})
    .then(response => response.json())
    .then(json => {
    	alert(json.res);
    	document.getElementById("name2").value="";
		document.getElementById("isbn2").value="";
		document.getElementById("writer2").value="";
		document.getElementById("kod2").value="";
		document.getElementById("izd2").value="";
		document.getElementById("count").value="";
    })
}
function nice(){
	console.log(1);
	document.getElementById("name2").value="";
	document.getElementById("isbn2").value="";
	document.getElementById("writer2").value="";
	document.getElementById("kod2").value="";
	document.getElementById("izd2").value="";
	document.getElementById("count").value="";
	document.getElementById("name1").value="";
	document.getElementById("isbn1").value="";
	document.getElementById("name").value="";
	document.getElementById("isbn").value="";
	document.getElementById("writer").value="";
	document.getElementById("kod").value="";
	document.getElementById("izd").value="";
	if(document.getElementById("table")!=null)
	table.remove();
}


