// base server URL 
let URL = `http://localhost:8088`; 

// Adding Event Listeners
document.getElementById("fetchAll").addEventListener("click",getUsers);
document.getElementById("fetchByAadhaar").addEventListener("click",getUserByAadhar);
document.getElementById("fetchByPan").addEventListener("click",getUserByPan);


async function getUserByPan(){
    let panNo=document.getElementById("panSearch");
    fetch(`${URL}/users/pan/${panNo}`).then(function(data){
        return data.json();
    }).then(function(data){
        // call Display Function
        display(data);
    })
}
async function getUserByAadhar(){
    let aNo=document.getElementById("aadhaarSearch");
    fetch(`${URL}/users/aadhar/${aNo}`).then(function(data){
        return data.json();
    }).then(function(data){
        // call Display Function
        display(data);
    })
}

async function getUsers(){
    fetch(`${URL}/getallusers`).then(function(data){
        return data.json();
    }).then(function(data){
        // call Display Function
        display(data);
    })
}
let mainSection=document.getElementById("right");

function display(data){
    let card=document.createElement("div");
    card.className="card";
    let cardList=document.createElement("div");
    cardList.className="card-list";
    data.forEach(function(item){
      cardList.append(createCard(item));
    })
    mainSection.append(cardList);
}

function createCard(item){
    let card=document.createElement("div");
    card.className="card";
    card.addEventListener("click",function(){
        document.getElementById("idTF").value=item.id;
        document.getElementById("nameTF").value=item.name;
        document.getElementById("dobTF").value=item.dob;
        document.getElementById("genderTF").value=item.gender;
        document.getElementById("addressTF").value=item.address;
        document.getElementById("cityTF").value=item.city;
        document.getElementById("stateTF").value=item.state;
        document.getElementById("pinTF").value=item.pincode;
        document.getElementById("panTF").value=item.panNo;
        document.getElementById("aadhaarTF").value=item.aadharNo    ;
    })
        let cardLeft=document.createElement("div");
            let namel=document.createElement("p");
            namel.innerText="Name:";
            let dobl=document.createElement("p");
            dobl.innerText="DOB:";
            let genderl=document.createElement("p");
            genderl.innerText="Gender:";
            let addressl=document.createElement("p");
            addressl.innerText="Address:";
            let cityl=document.createElement("p");
            cityl.innerText="City:";
            let statel=document.createElement("p");
            statel.innerText="State:";
            let pincodel=document.createElement("p");
            pincodel.innerText="Pincode:";
            let panl=document.createElement("p");
            panl.innerText="Pan:";
            let aadhaarl=document.createElement("p");
            aadhaarl.innerText="Aadhaar:";
        cardLeft.append(namel,dobl,genderl,addressl,cityl,statel,pincodel,panl,aadhaarl);

        let cardRight=document.createElement("div");
            let name=document.createElement("p");
            name.innerText=item.name;
            let dob=document.createElement("p");
            dob.innerText=item.dob;
            let gender=document.createElement("p");
            gender.innerText=item.gender;
            let address=document.createElement("p");
            address.innerText=item.address;
            let city=document.createElement("p");
            city.innerText=item.city;
            let state=document.createElement("p");
            state.innerText=item.state;
            let pincode=document.createElement("p");
            pincode.innerText=item.pincode;
            let pan=document.createElement("p");
            pan.innerText=item.panNo;
            let aadhaar=document.createElement("p");
            aadhaar.innerText=item.aadharNo;
        cardRight.append(name,dob,gender,address,city,state,pincode,pan,aadhaar);
        card.append(cardLeft,cardRight);
        return card;
}