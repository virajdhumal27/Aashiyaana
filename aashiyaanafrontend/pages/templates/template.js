// isUserLoggedIn();
let API_URL = "http://192.168.239.65:9191";
if(livingRoomData == true) {
    API_URL = API_URL + "/rooms/livingrooms/users/1";
}
// Pre-fetches data.
const responseData = fetch(API_URL)
.then(response => response.json())
.then(data => {
  console.log(data);
  return data;
})
.catch(error => {
  console.error(error);
  return null;
});

showCards();

createLoadMoreButton();

showProductsPreview();

previewCardsLogic();

loadMoreCards();



function isUserLoggedIn() {
  alert(localStorage.getItem('userid') + ", " + localStorage.getItem('username'));
  if (localStorage.length == 0) {
    window.location.replace("http://127.0.0.1:5500/login_form.html");
  }

  alert(localStorage.getItem('userid') + ", " + localStorage.getItem('username'));
  window.localStorage.clear();
}

function previewCardsLogic() {
  let preveiwContainer = document.querySelector('.products-preview');
  let previewBox = preveiwContainer.querySelectorAll('.preview');

  document.querySelectorAll('.products-container .product').forEach(product => {
    product.onclick = () => {
      preveiwContainer.style.display = 'flex';
      let name = product.getAttribute('data-name');
      previewBox.forEach(preview => {
        let target = preview.getAttribute('data-target');
        if (name == target) {
          preview.classList.add('active');
        }
      });
    };
  });

  previewBox.forEach(close => {
    close.querySelector('.fa-times').onclick = () => {
      close.classList.remove('active');
      preveiwContainer.style.display = 'none';
    };
  });
}

function loadMoreCards() {
  let loadMoreBtn = document.querySelector('#load-more');
  let currentItem = 9;

  loadMoreBtn.onclick = () => {
    let boxes = [...document.querySelectorAll('.container .products-container .product')];
    for (var i = currentItem; i < 30; i++) {
      boxes[i].style.display = 'inline-block';
    }
    currentItem += 30;

    if (currentItem >= boxes.length) {
      loadMoreBtn.style.display = 'none';
    }
  }
}


async function showCards() {
  const productsConatiner = document.getElementById("products-container");
  const data = await responseData;
  for (let i = 0; i < 30; i++) {
    const product = createCard(i + 1,data.rooms[0]);
    console.log(product);
    productsConatiner.appendChild(product);
  }
}

function createCard(cardNo, room) {
  const product = document.createElement("div");
  let image = document.createElement("img");
  const h3 = document.createElement("h3");

  product.setAttribute("data-name", `p-${cardNo}`);
 
  image.src = "../templates/living_room/whiteyellowgrey.jpg";
  image.alt = "IMAGE";
  image.height = "450";
  image.width = "300";

  h3.innerHTML = room.title;

  product.classList.add("product");

  product.appendChild(image);
  product.appendChild(h3);

  return product;
}

function createLoadMoreButton() {
  const productsConatiner = document.getElementById("container");
  const loadMore = document.createElement("div");
  loadMore.id = "load-more";
  loadMore.innerHTML = "Load More";
  productsConatiner.appendChild(loadMore);
}

async function showProductsPreview() {
  const productsPreview = document.getElementById("products-preview");

  const data = await responseData;

  for (let i = 0; i < 30; i++) {
    const my_preview = createProductsPreview(i + 1, data.rooms[0]);
    console.log(my_preview);
    productsPreview.appendChild(my_preview);
  }
}

function createProductsPreview(cardNo, room) {

  const preview = document.createElement("div");

  const iTag = document.createElement("i");
  let image = document.createElement("img");
  const h3 = document.createElement("h3");

  const starsGroup = document.createElement("div");
  const starFull1 = document.createElement("i");
  const starFull2 = document.createElement("i");
  const starFull3 = document.createElement("i");
  const starFull4 = document.createElement("i");
  const starHalf = document.createElement("i");
  const ratings = document.createElement("span");

  const priceTag = document.createElement("div");

  preview.classList.add("preview");
  preview.setAttribute("data-target", `p-${cardNo}`);

  iTag.classList.add("fas");
  iTag.classList.add("fa-times");
  image.src = "../templates/living_room/whiteyellowgrey.jpg";
  image.height = "350";
  image.width = "250";
  image.alt = "IMAGE";

  h3.innerHTML = room.title;

  starsGroup.classList.add("stars");

  starFull1.classList.add("fas");
  starFull1.classList.add("fa-star");

  starFull2.classList.add("fas");
  starFull2.classList.add("fa-star");

  starFull3.classList.add("fas");
  starFull3.classList.add("fa-star");

  starFull4.classList.add("fas");
  starFull4.classList.add("fa-star");

  starHalf.classList.add("fas");
  starHalf.classList.add("fa-star-half-alt");

  ratings.innerHTML = room.reviews;

  starsGroup.appendChild(starFull1);
  starsGroup.appendChild(starFull2);
  starsGroup.appendChild(starFull3);
  starsGroup.appendChild(starFull4);
  starsGroup.appendChild(starHalf);
  starsGroup.appendChild(ratings);

  priceTag.classList.add("price");
  priceTag.innerHTML = room.price;

  preview.appendChild(iTag);
  preview.appendChild(image);
  preview.appendChild(h3);
  preview.appendChild(starsGroup);
  preview.appendChild(priceTag);

  return preview;
}