const navSlideS = () => {
	const burger = document.querySelector('.burger_shoppage');
	const shopnav = document.querySelector('.custom-menu');
	const navOut = document.querySelector('.headernav');
        const height90=document.querySelector('.height90');


	burger.addEventListener('click', () =>{
		shopnav.classList.toggle('nav-active');
//		burger.style.zIndex="1000";
//                 navOut.classList.toggle('height90');

	})
}
navSlideS();