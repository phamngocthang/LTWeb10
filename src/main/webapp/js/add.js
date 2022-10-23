function FilterShow(pricePold, pricePnew, indexP, showP)
{
	/*
	if(pricePold == null)
	{
		var price = 0 + Number(pricePnew); 
	}
	else
	{
		var price = Number(pricePold) + Number(pricePnew);
	}
	console.log(price)
	console.log(typeof(indexP))
	*/
	var result = "shop?index=" + String(indexP) + "&showP="+ String(showP);
	window.location=result;
	console.log(result)
}