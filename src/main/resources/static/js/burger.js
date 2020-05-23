/* 
 * Created on 21/05/2020 at 18:37:14 GMT+2
 */

const navSlide = () => {
	const burger = document.querySelector('.burger');
	const nav = document.querySelector('.nav-links');
	const navOut = document.querySelector('.headernav');


	burger.addEventListener('click', () =>{
		nav.classList.toggle('nav-active');
		burger.style.zIndex="1000";

	})
}
navSlide();