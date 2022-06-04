
function randomInteger(min, max) {
  return Math.floor(Math.random() * (max - min + 1)) + min;
}

function make_txt(){
    let text = "";
    let possible = "abcdefghijklmnopqrstuvwxyz";
    let qwe=randomInteger(4,20);
    for( let i=0; i < qwe; i++ )
        text += possible.charAt(Math.floor(Math.random() * possible.length));

    return text;
}
let ans=0;
function create_Ul(){
	let count=randomInteger(1,15);
	let x=randomInteger(1,2);
	for(let i=0;i<count;i++){
		let li = document.createElement('li');
		li.id='li';
  		li.innerHTML = make_txt();
  		ul.append(li);
		ans++;
		if(x<2){
			x++;
			ans++;
			let qqq = document.createElement('ul');
  			//qqq.innerHTML = make_txt();
  			ul.append(qqq);
  			qqq.id='qwe';
  			let count1=randomInteger(1,10);
  			for(let j=0;j<count1;j++){
  				ans++;
  				let lili = document.createElement('li');
				lili.innerHTML = make_txt();
				lili.id='lili';
  				qwe.append(lili);

  			}
		}
	}
}
	
function bubbleSort(arr) {
    for (let i = 0, endI = arr.length - 1; i < endI; i++) {
        for (let j = 0, endJ = endI - i; j < endJ; j++) {
            if (arr[j] > arr[j + 1]) {
                let swap = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = swap;
            }
        }
    }
    return arr;

}

function sortList(sss){
   let new_ul = sss.cloneNode(false);

    // Add all lis to an array
    let lis = [];
    let res=[];
    let count;
    for(let i = sss.childNodes.length; i--;){
        if(sss.childNodes[i].nodeName === 'LI')
            lis.push(sss.childNodes[i].innerHTML);
        else if(sss.childNodes[i].nodeName ==='UL'){
        	count=i;
        	for(let j=sss.childNodes[i].childNodes.length;j--){
        		if(sss.childNodes[i].childNodes[j].nodeName === 'LI')
        		lis.push(qwe.childNodes[j].innerHTML);
        	}
        }
    }

    // Sort the lis in descending order
   bubbleSort(lis);
    // Add them into the ul in order
   for(let i = 0; i <sss.childNodes.length; i++)
        sss.childNodes[i+1].innerHTML=lis[i];
        //sss.appendChild(lis[i]);
    	//sss.replaceChild(new_ul, sss);
}


