usage guide:
	The given java program accepts command with url as parameter in 		'command url' format.
commands:
	'storeurl','get','count','list','exit'
	'list' command doesnt have a parameter;
eg:
	storeurl www.google.com
	get www.google.com
	count www.google.com
	list

	exit command will exit the program.

features:

->storeurl url:stores the url and a unique short key is maintained
->get :	it returns the short key after incrementing usage count
->count: returns usage count
->list: returns full pojo in json format
->incase if a user entered in a wrong format it will print invalid command or 	  url.
->menu driven user interface