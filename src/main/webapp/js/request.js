function post(URL, PARAMS)
{
	var temp = document.createElement("form");
	temp.action = URL;
	temp.method = "post";
	temp.style.display = "none";
	for (var x in PARAMS)
	{
		var opt = document.createElement("textarea");
		opt.name = x;
		opt.value = PARAMS[x];
		//alert(opt.name);
		temp.appendChild(opt);
	}
	document.body.appendChild(temp);
	temp.submit();
	document.getElementById("rollback").submit();
	return temp;
}

function get(URL, PARAMS)
{
    var temp = document.createElement("form");
    temp.method = "get";
    temp.style.display = "none";
    var data = "?";
    for (var x in PARAMS)
    {
        data += x + "=" + PARAMS[x] + "&";;
    }
    data = data.slice(0, data.length-1);
    temp.action = URL + data;
    document.body.appendChild(temp);
    temp.submit();
    return temp;
}