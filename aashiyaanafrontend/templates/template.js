console.log(API_URL);
callApi();

showCards();
createLoadMoreButton();

showProductsPreview();

previewCardsLogic();

loadMoreCards();

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


function showCards() {
  const productsConatiner = document.getElementById("products-container");
  for (let i = 0; i < 30; i++) {

    const product = createCard(i + 1);

    productsConatiner.appendChild(product);
  }
}

function createCard(cardNo) {
  const product = document.createElement("div");
  const image = document.createElement("img");
  const h3 = document.createElement("h3");
  const priceTag = document.createElement("div");

  product.setAttribute("data-name", `p-${cardNo}`);



  image.src = "http://127.0.0.1:5500/flower.jpg";
  image.alt = "IMAGE";
  image.height = "450px";
  image.width = "300px";

  h3.innerHTML = "Card Title";

  priceTag.innerHTML = "2.00";

  product.classList.add("product");
  priceTag.classList.add("price");

  product.appendChild(image);
  product.appendChild(h3);
  product.appendChild(priceTag);

  return product;
}

function createLoadMoreButton() {
  const productsConatiner = document.getElementById("products-container");
  const loadMore = document.createElement("div");
  loadMore.id = "load-more";
  loadMore.innerHTML = "Load More";
  productsConatiner.appendChild(loadMore);
}










function showProductsPreview() {
  const productsPreview = document.getElementById("products-preview");

  for (let i = 0; i < 30; i++) {
    const my_preview = createProductsPreview(i + 1);
    productsPreview.appendChild(my_preview);
  }


}

function createProductsPreview(cardNo) {

  
  const preview = document.createElement("div");

  const iTag = document.createElement("i");
  const image = document.createElement("img");
  const h3 = document.createElement("h3");

  const starsGroup = document.createElement("div");
  const starFull1 = document.createElement("i");
  const starFull2 = document.createElement("i");
  const starFull3 = document.createElement("i");
  const starFull4 = document.createElement("i");
  const starHalf = document.createElement("i");
  const ratings = document.createElement("span");

  const description = document.createElement("p");
  const priceTag = document.createElement("div");

  const buttons = document.createElement("div");
  const buyNowButton = document.createElement("a");
  const addToCartButton = document.createElement("a");

  preview.classList.add("preview");
  preview.setAttribute("data-target", `p-${cardNo}`);

  iTag.classList.add("fas");
  iTag.classList.add("fa-times");
  image.src = "http://127.0.0.1:5500/flower.jpg";
  image.height = "350";
  image.width = "250";
  image.alt = "IMAGE";

  h3.innerHTML = "Organic Strawberries";

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

  ratings.innerHTML = "( 250 )";

  starsGroup.appendChild(starFull1);
  starsGroup.appendChild(starFull2);
  starsGroup.appendChild(starFull3);
  starsGroup.appendChild(starFull4);
  starsGroup.appendChild(starHalf);
  starsGroup.appendChild(ratings);

  description.innerHTML = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Consequatur, dolorem.";

  priceTag.classList.add("price");
  priceTag.innerHTML = "$2.00";

  buttons.classList.add("buttons");
  buyNowButton.classList.add("buy");
  buyNowButton.href = "#";
  buyNowButton.innerHTML = "Buy Now"

  addToCartButton.classList.add("cart");
  addToCartButton.href = "#";
  addToCartButton.innerHTML = "Add to Cart";

  buttons.appendChild(buyNowButton);
  buttons.appendChild(addToCartButton);

  preview.appendChild(iTag);
  preview.appendChild(image);
  preview.appendChild(h3);
  preview.appendChild(starsGroup);
  preview.appendChild(description);
  preview.appendChild(priceTag);
  preview.appendChild(buttons);

  return preview;
}

async function callApi() {
  const response = await fetch(API_URL);
  const data = await response.json();
  console.log(data);
  // return [data.rooms];
}

/* rooms: [
  {
    id: 1
    title: "Title1"
    description: "Description1"
    roomType: "LIVING_ROOM"
    price: 100
    stars: 5
    reviews: 250
    image_url: "URL1"
  },
  {
    id: 2
    title: "Title2"
    description: "Description2"
    roomType: "LIVING_ROOM"
    price: 200
    stars: 4.5
    reviews: 200
    image_url: "URL2"
  }
]

*/