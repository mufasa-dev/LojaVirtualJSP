function ApenasNumeros(e)
{
	let tecla=new Number();
	if(window.event) {
		tecla = e.keyCode;
	}
	else if(e.which) {
		tecla = e.which;
	}
	else {
		return true;
	}
	if((tecla >= "97") && (tecla <= "122")){
		return false;
	}
}



function setaMais(){
    let nFoto =  document.getElementById("txtFoto").value;
    let res = parseInt(nFoto) + 1; 
    if(res > 50 ){
        res = 50;
    }
    document.getElementById("txtFoto").value = res;
    altImagem();
}

function setaMenos(){
    let nFoto =  document.getElementById("txtFoto").value;
    let res = parseInt(nFoto) - 1; 
    if(res < 1){
        res = 1;
    }
    document.getElementById("txtFoto").value = res;
    altImagem();
}

function altImagem(){
    let nFoto =  document.getElementById("txtFoto").value;
    if(nFoto < 1){
        nFoto = 1;
    }else if(nFoto > 50){
        nFoto = 50;
    }
    document.getElementById("txtFoto").value = nFoto;
    document.getElementById("imgFoto").src = "img/produtos/" + nFoto + ".jpg";
}

function validaFormCadProduto(){
    let nome = document.getElementById("txtNomeCad").value;
    let marca = document.getElementById("txtMarcaCad").value;
    let Descri = document.getElementById("txtDescriCad").value;
    let foto = document.getElementById("txtFoto").value;
    let preco = document.getElementById("txtPrecoCad").value;
    if(nome == "" || marca == "" || Descri == "" || foto == "" || preco == ""){
        document.getElementById("BtnCad").disabled = 1;
    }else{
        document.getElementById("BtnCad").disabled = 0;
    }
}