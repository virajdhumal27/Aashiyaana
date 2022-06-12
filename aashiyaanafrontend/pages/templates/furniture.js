const USER_ID = 'userid';
const USER_NAME = 'username';

let API_URL = "http://192.168.239.65:9191";

const handleLogoutButton = async () => {
    API_URL = API_URL + '/login/logoutUser';
  
    const userid = localStorage.getItem(USER_ID);
    const username = localStorage.getItem(USER_NAME);
    const data = { userid, username };
    const options = {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(data)
    };
    
    const response = await fetch(API_URL, options);
    const responseData = await response.json();
    if(responseData.isLogoutSuccess) {
      localStorage.removeItem(USER_ID);
      localStorage.removeItem(USER_NAME);
      localStorage.clear();
      window.location.replace("../login-signup/login_form.html?#");
    }
    console.log(responseData);
    
}

const isUserLoggedIn = () => {
    
    //   window.localStorage.clear();
    // alert(localStorage.getItem('userid') + ", " + localStorage.getItem('username'));
    if(localStorage.length == 0) {
        window.location.replace("../login-signup/login_form.html?#");
    }
    
    // alert(localStorage.getItem('userid') + ", " + localStorage.getItem('username'));
}



isUserLoggedIn();

const buttonColors = {
    Item1: ["#d98cb3", "#70dbdb", "#77dd77"],
    Item2: ["#e0bbe4", "#77dd77", "#70dbdb"],
    Item3: ["#e0bbe4", "#70dbdb", "#77dd77"],
    Item4: ["#3c1361", "#2b910e", "#003572"],
    Item5: ["#e0bbe4", "#e4a0b7", "#70dbdb"],
    Item6: ["#3bbdc2", "#3ea055", "#3c0064"],
    Item7: ["#70dbdb", "#77dd77", "#e0bbe4"],
    Item8: ["#ffd1dc", "#e0bbe4", "#d1ffd5"],
    Item9: ["#3c1361", "#2b910e", "#003572"],
    Item10: ["#32612d", "#0492c2", "#8b0000"],
    Item11: ["#e9cfec", "#98fb98", "#82eefd"],
    Item12: ["#e9cfec", "#98fb98", "#82eefd"],
};



const drop = () => {
    const dropdown = document.getElementById("room-dropdown");
    const bedroom = document.getElementById("bed-room");
    const livroom = document.getElementById("liv-room");

    const selectedRoom = dropdown.value;

    if (selectedRoom === "liv") {
        bedroom.classList.add("d-none");
        livroom.classList.remove("d-none");
    } else if (selectedRoom === "bed") {
        livroom.classList.add("d-none");
        bedroom.classList.remove("d-none");
    }
}

const displayImage = (imageId) => {
    const pic = document.getElementById(imageId);
    const imageSrc = pic.src;

    const mainImage = document.getElementById("displayMain");
    mainImage.src = imageSrc;

    for (let i = 0; i < 3; i++) {

        switch (imageId) {
            case "item1":
                document.getElementById(`btn-${i + 1}`).style.backgroundColor = buttonColors.Item1[i];
                break;
            case "item2":
                document.getElementById(`btn-${i + 1}`).style.backgroundColor = buttonColors.Item2[i];
                break;
            case "item3":
                document.getElementById(`btn-${i + 1}`).style.backgroundColor = buttonColors.Item3[i];
                break;
            case "item4":
                document.getElementById(`btn-${i + 1}`).style.backgroundColor = buttonColors.Item4[i];
                break;
            case "item5":
                document.getElementById(`btn-${i + 1}`).style.backgroundColor = buttonColors.Item5[i];
                break;
            case "item6":
                document.getElementById(`btn-${i + 1}`).style.backgroundColor = buttonColors.Item6[i];
                break;
            case "item7":
                document.getElementById(`btn-${i + 1}`).style.backgroundColor = buttonColors.Item7[i];
                break;
            case "item8":
                document.getElementById(`btn-${i + 1}`).style.backgroundColor = buttonColors.Item8[i];
                break;
            case "item9":
                document.getElementById(`btn-${i + 1}`).style.backgroundColor = buttonColors.Item9[i];
                break;
            case "ward1":
                document.getElementById(`btn-${i + 1}`).style.backgroundColor = buttonColors.Item10[i];
                break;
            case "ward2":
                document.getElementById(`btn-${i + 1}`).style.backgroundColor = buttonColors.Item11[i];
                break;
            case "ward3":
                document.getElementById(`btn-${i + 1}`).style.backgroundColor = buttonColors.Item12[i];
                break;

            default:
                break;
        }
    }
}

const changeColor = (id) => {
    const mainImage = document.getElementById("displayMain");
    
    const text = mainImage.src;
    let itemNumber = 0;
    let index = text.indexOf("item");
    if(index == -1) {
        itemNumber = text.indexOf("ward") + 4;
    } else {
        itemNumber = text.indexOf("item") + 4;
    }
    
    const folderNumber = text[itemNumber];
    console.log(folderNumber);

    let url = "";
    if(index == -1) {
        url = buildWardUrl(folderNumber, id);
    } else {
        url = buildItemUrl(folderNumber, id);
    }
    
    mainImage.src = url;
}

const displayImageWard = (id) => {
    const pic = document.getElementById(id);
    const imageSrc = pic.src;

    const mainImage = document.getElementById("displayMain");
    mainImage.src = imageSrc;
    
    const text = mainImage.src;
    let itemNumber = text.indexOf("ward") + 4;
    console.log("", itemNumber);
    const folderNumber = text.charAt(itemNumber);
    console.log(folderNumber);

    const url = `./DIYphotos/ward${folderNumber}/ward${folderNumber}${id}.jpeg`;
    
    mainImage.src = url;
}

const buildItemUrl = (folderNumber, btn) => {
    const url = `./DIYphotos/item${folderNumber}/item${folderNumber}${btn}.jpeg`;

    return url;
}

const buildWardUrl = (folderNumber, btn) => {
    const url = `./DIYphotos/ward${folderNumber}/ward${folderNumber}${btn}.jpeg`;

    return url;
}