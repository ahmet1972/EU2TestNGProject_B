package com.cybertek.tests.ahmetsHomework;

public class BasicNavigation01 {

    /*
    Basic	Navigation	Tests
Creating project
1. Create	a	new	project	named	BasicNavigationTests	using	IntelliJ.
2. Add	all	the	required	selenium	dependencies.
3. Under	src	create	two	packages	com.cbt.utilities	and	com.cbt.tests.
Utilities
1. Create	class	BrowserFactory	under	utilities	package.
2. Create	a	public	static	method	getDriver	which	takes	a	string	argument.
3. If	you	are	using	Windows,	and	if	the	String	argument	is	`safari`,	return	null.
If	 you	are	using	Mac,	and	if	the	String	argument	is	`edge`,	return	null.
NOTE	For	this	step,	you	need	to	research	how	to	find	out	your	operating
system	programmatically	using	Java.
4. In	all	other	cases,	return	a	new	WebDriver	object	for	ChromeDriver,
FirefoxDriver,	EdgeDriver	or	SafariDriver	based	on	the	value	of	the	string	 argument.
NOTE: For this exercise, you need to research how to launch	Edge using Selenium if you are using Windows.
NOTE:For this exercise,	you	need to	research how to	launch Safari using Selenium if	you	are	using Mac.

5. Create	class	StringUtility	under	utilities	package.
6. Create	a	public	static	method	verifyEquals	which	takes	two	string	arguments,
expected	and	actual.
7. The	method	prints	`PASS`	if	both	strings	are	equals	to	each	other.
Else	it	prints	 `FAIL`	and	it	also	prints	the	values	of	both	arguments.
Tests
1. 	Create	class	NavigationTests	under	tests	package.
2. Automate	the	provided	test	case	using	3	different	browsers.
3. Create	a	separate	test	method	for	each	browser.
    a. If	you	are	using	Windows,	create	test	methods	for	Chrome,	Firefox,	 Edge.
    b. If	you	are	using	Windows,	create	test	methods	for	Chrome,	Firefox,	 Safari.
4. Each	test	should	close	the	browser	after	completion.
5. Test	methods	must	use	the	utilities.
6. Run	all	three	test	methods	from	the	main	method.
Test	Case
1. Open	browser
2. Go	to	website	https://google.com
3. Save	the	title	in	a	string	variable
4. Go	to	https://etsy.com
5. Save	the	title	in	a	string	variable
6. Navigate	back	to	previous	page
7. Verify	that	title	is	same	is	in	step	3
8. Navigate	forward	to	previous	page
9. Verify	that	title	is	same	is	in	step	5
     */


}
