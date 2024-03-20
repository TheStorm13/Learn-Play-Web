const bgImage = document.querySelector('.bg-image')
const carousel = document.querySelector('.carousel')
const imagesInCarousel = document.querySelectorAll('.carousel img')
const totalNumberOfCarouselImages = imagesInCarousel.length
const leftArrow = document.querySelector('.left-arrow')
const rightArrow = document.querySelector('.right-arrow')

rightArrow.addEventListener('click', handleRightArrowClick)
leftArrow.addEventListener('click', handleLeftArrowClick)

let currentIndex = 0
let prevIndex
let amountOfCarouselTranslation = 520

function handleRightArrowClick() {
	carousel.classList.add('sliding-transition')
	prevIndex = currentIndex
	currentIndex = (currentIndex + 1) % totalNumberOfCarouselImages
	carousel.style.transform = `translateX(-${amountOfCarouselTranslation}px)`
	bgImage.src = imagesInCarousel[currentIndex].src.slice(0, -3) + '1000'

	setTimeout(() => {
		carousel.appendChild(imagesInCarousel[prevIndex])
		carousel.style.transform = 'translateX(0)'
		carousel.classList.remove('sliding-transition')
	}, 600)
}

function handleLeftArrowClick() {
	prevIndex = currentIndex
	currentIndex = (currentIndex - 1 + totalNumberOfCarouselImages) % totalNumberOfCarouselImages

	carousel.insertBefore(imagesInCarousel[currentIndex], carousel.firstElementChild)
	carousel.style.transform = `translateX(-${amountOfCarouselTranslation}px)`
	bgImage.src = imagesInCarousel[currentIndex].src.slice(0, -3) + '1000'
	setTimeout(() => {
		carousel.style.transform = ''
		carousel.classList.add('sliding-transition')
	}, 50)

	setTimeout(() => {
		carousel.classList.remove('sliding-transition')
	}, 600)
}