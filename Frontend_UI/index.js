  //   let count=0;
  //  let id=0;

  //  let str="Rocker Online Plant Nursery Application ";
   
  //  id=setInterval (function(){
  //   let newstr=str[count];
  //   if(count==str.length-1){
  //       count=0;
  //       document.getElementById("textRocker").innerText=null;
  //   }
  //   newstr=str[count];
  //   document.getElementById("textRocker").append(newstr);
  //   count++;
  //  },300);
  let user=""

   function checkfun(){
    document.getElementById("slide_menu").style.top="0%"
  }
  function cencel(){
    document.getElementById("slide_menu").style.top="-100%";
  }
  function cencelS(){
    document.getElementById("slide_menu").style.top="-100%";
    document.getElementById("login").style.display="none";
    document.getElementById("signup").style.display="block";
  }
  function cencelL(){
    document.getElementById("slide_menu").style.top="-100%";
    document.getElementById("signup").style.display="none";
    document.getElementById("login").style.display="block";
  }

  function msg_submit(){
    let msg=document.getElementById("msg").value;
    console.log(msg)
  }
  function signupHide(){
    document.getElementById("signup").style.display="none";
  }
  function loginHide(){
    document.getElementById("login").style.display="none";
  }

  //  Login Toggle Admin -> Customer
let toogleU= document.getElementById("toggleU");
let toogleP=document.getElementById("toggleP");
let adminToggle=document.getElementById("adminToggle");
let customerToggle=  document.getElementById("customerToggle");

// Methods and Content Toggle

let planterToggle=  document.getElementById("planterToggle")
let plantToggle= document.getElementById("plantToggle")
let seedToggle=  document.getElementById("seedToggle")
let planterToggle1=  document.getElementById("cplanterToggle")
let plantToggle1= document.getElementById("cplantToggle")
let seedToggle1=  document.getElementById("cseedToggle")
let orderToggle=  document.getElementById("orderToggle")
let profileToggle=  document.getElementById("profileToggle")


//  Container

let Pcontainer=document.getElementById("acontainerPlanter");
let pcontainer=document.getElementById("acontainerPlant");
let Scontainer=document.getElementById("acontainerSeed");
let Pcontainer1=document.getElementById("ccontainerPlanter");
let pcontainer1=document.getElementById("ccontainerPlant");
let Scontainer1=document.getElementById("ccontainerSeed");
let Ocontainer=document.getElementById("containerOrder");
let profilecontainer=document.getElementById("containerProfile");


// planter
let P1=document.getElementById("addPlanterData");
let P2=document.getElementById("updatePlanterData");
let P3=document.getElementById("deletePlanterData");
let P4=document.getElementById("agetPlanterById");
let P5=document.getElementById("agetPlanterByShape");
let P6=document.getElementById("agetPlanters");
let P7=document.getElementById("agetPlanterByCostRange");
let P41=document.getElementById("cgetPlanterById");
let P51=document.getElementById("cgetPlanterByShape");
let P61=document.getElementById("cgetPlanters");
let P71=document.getElementById("cgetPlanterByCostRange");

// plant
let p1=  document.getElementById("addPlantData");
let p2=  document.getElementById("updatePlantData");
let p3=  document.getElementById("deletePlantData");
let p4=  document.getElementById("agetPlantByIdData");
let p5=  document.getElementById("agetPlantByNameData");
let p6=  document.getElementById("agetPlantsData");
let p7=  document.getElementById("agetPlantByTypeData");
let p41=  document.getElementById("cgetPlantByIdData");
let p51=  document.getElementById("cgetPlantByNameData");
let p61=  document.getElementById("cgetPlantsData");
let p71=  document.getElementById("cgetPlantByTypeData");

// seed
let s1=  document.getElementById("addSeedData");
let s2=  document.getElementById("updateSeedData");
let s3=  document.getElementById("deleteSeedData");
let s4=  document.getElementById("agetSeedByIdData");
let s5=  document.getElementById("agetSeedByNameData");
let s6=  document.getElementById("agetSeedsData");
let s7=  document.getElementById("agetSeedByTypeData");
let s41=  document.getElementById("cgetSeedByIdData");
let s51=  document.getElementById("cgetSeedByNameData");
let s61=  document.getElementById("cgetSeedsData");
let s71=  document.getElementById("cgetSeedByTypeData");


//  Order

let o1=  document.getElementById("addOrderData");
let o2=  document.getElementById("updateOrderData");
let o3=  document.getElementById("deleteOrderData");
let o4=  document.getElementById("getOrderByIdData");
let o5=  document.getElementById("getOrderData");

//  Profile 

let c1 = document.getElementById("updateProfileData");
let c2 = document.getElementById("getProfileByIdData");




 function changeToAdmin(){
toggleU.innerHTML="Admin"
toggleP.innerHTML="Admin"
adminToggle.style.backgroundColor="black";
adminToggle.style.color="white";
customerToggle.style.backgroundColor="transparent";
customerToggle.style.color="black";
 }
 function changeToCustomer(){
toggleU.innerHTML="Customer"
toggleP.innerHTML="Customer"
customerToggle.style.backgroundColor="black";
customerToggle.style.color="white";
adminToggle.style.backgroundColor="transparent";
adminToggle.style.color="black";
 }


 function changeToColor(numberMethod){
planterToggle.style.backgroundColor="transparent";
planterToggle.style.color="black";
plantToggle.style.backgroundColor="transparent";
plantToggle.style.color="black";
seedToggle.style.backgroundColor="transparent";
seedToggle.style.color="black";
planterToggle1.style.backgroundColor="transparent";
planterToggle1.style.color="black";
plantToggle1.style.backgroundColor="transparent";
plantToggle1.style.color="black";
seedToggle1.style.backgroundColor="transparent";
seedToggle1.style.color="black";
orderToggle.style.backgroundColor="transparent";
orderToggle.style.color="black";
profileToggle.style.backgroundColor="transparent";
profileToggle.style.color="black";
event.target.style.backgroundColor="black";
event.target.style.color="white";
Pcontainer.style.display="none";
pcontainer.style.display="none";
Scontainer.style.display="none";
Pcontainer1.style.display="none";
pcontainer1.style.display="none";
Scontainer1.style.display="none";
Ocontainer.style.display="none";
profilecontainer.style.display="none";
if(numberMethod==1){
  Pcontainer.style.display="flex";
    }else if(numberMethod==2){
      pcontainer.style.display="flex";
    }else if(numberMethod==3){
  Scontainer.style.display="flex";
    }else if(numberMethod==4){
      Ocontainer.style.display="flex";
    }else if(numberMethod==5){
      profilecontainer.style.display="flex";
    }else if(numberMethod==6){
      Pcontainer1.style.display="flex";
        }else if(numberMethod==7){
          pcontainer1.style.display="flex";
        }else if(numberMethod==8){
          Scontainer1.style.display="flex";
        }
 }



//  Planter Function


function addPlanterFun1(numberMethod){
  P1.style.display="none";
  P2.style.display="none";
  P3.style.display="none";
  P4.style.display="none";
  P5.style.display="none";
  P6.style.display="none";
  P7.style.display="none";
  P41.style.display="none";
  P51.style.display="none";
  P61.style.display="none";
  P71.style.display="none";

  p1.style.display="none";
p2.style.display="none";
p3.style.display="none";
p4.style.display="none";
p5.style.display="none";
p6.style.display="none";
p7.style.display="none";
p41.style.display="none";
p51.style.display="none";
p61.style.display="none";
p71.style.display="none";

s1.style.display="none";
  s2.style.display="none";
  s3.style.display="none";
    s4.style.display="none";
    s5.style.display="none";
    s6.style.display="none";
    s7.style.display="none";  
    s41.style.display="none";
    s51.style.display="none";
    s61.style.display="none";
    s71.style.display="none"; 

    o1.style.display="none";
      o2.style.display="none";
      o3.style.display="none";
        o4.style.display="none";
        o5.style.display="none";

    c1.style.display="none";
    c2.style.display="none";


  if(numberMethod==1){
P1.style.display="block";
  }else if(numberMethod==2){
P2.style.display="block";
  }else if(numberMethod==3){
P3.style.display="block";
  }else if(numberMethod==4){
P4.style.display="block";
  }else if(numberMethod==5){
P5.style.display="block";
  }else if(numberMethod==6){
P6.style.display="block";
  }else if(numberMethod==7){
P7.style.display="block";
  }else if(numberMethod==8){
    P41.style.display="block";
      }else if(numberMethod==9){
    P51.style.display="block";
      }else if(numberMethod==10){
    P61.style.display="block";
      }else if(numberMethod==11){
    P71.style.display="block";
      }
}

//  Plant Function 
function addPlantFun(numberMethod){
p1.style.display="none";
p2.style.display="none";
p3.style.display="none";
p4.style.display="none";
p5.style.display="none";
p6.style.display="none";
p7.style.display="none";
p41.style.display="none";
p51.style.display="none";
p61.style.display="none";
p71.style.display="none";



P1.style.display="none";
  P2.style.display="none";
  P3.style.display="none";
  P4.style.display="none";
  P5.style.display="none";
  P6.style.display="none";
  P7.style.display="none";
  P41.style.display="none";
  P51.style.display="none";
  P61.style.display="none";
  P71.style.display="none";

  s1.style.display="none";
  s2.style.display="none";
  s3.style.display="none";
    s4.style.display="none";
    s5.style.display="none";
    s6.style.display="none";
    s7.style.display="none";  
    s41.style.display="none";
    s51.style.display="none";
    s61.style.display="none";
    s71.style.display="none";
   

    o1.style.display="none";
      o2.style.display="none";
      o3.style.display="none";
        o4.style.display="none";
        o5.style.display="none";

    c1.style.display="none";
    c2.style.display="none";

  if(numberMethod==1){
p1.style.display="block";
  }else if(numberMethod==2){
p2.style.display="block";
  }else if(numberMethod==3){
p3.style.display="block";
  }else if(numberMethod==4){
p4.style.display="block";
  }else if(numberMethod==5){
p5.style.display="block";
  }else if(numberMethod==6){
p6.style.display="block";
  }else if(numberMethod==7){
p7.style.display="block";
  }else if(numberMethod==8){
    p41.style.display="block";
      }else if(numberMethod==9){
    p51.style.display="block";
      }else if(numberMethod==10){
    p61.style.display="block";
      }else if(numberMethod==11){
    p71.style.display="block";
      }
}

//seed Function

function addSeedFun(numberMethod){

p1.style.display="none";
p2.style.display="none";
p3.style.display="none";
p4.style.display="none";
p5.style.display="none";
p6.style.display="none";
p7.style.display="none";

P1.style.display="none";
P2.style.display="none";
P3.style.display="none";
  P4.style.display="none";
  P5.style.display="none";
  P6.style.display="none";
  P7.style.display="none";

  s1.style.display="none";
  s2.style.display="none";
  s3.style.display="none";
    s4.style.display="none";
    s5.style.display="none";
    s6.style.display="none";
    s7.style.display="none";  

    o1.style.display="none";
    o2.style.display="none";
    o3.style.display="none";
      o4.style.display="none";
      o5.style.display="none";

    c1.style.display="none";
    c2.style.display="none";
    s41.style.display="none";
    s51.style.display="none";
    s61.style.display="none";
    s71.style.display="none";
    p41.style.display="none";
    p51.style.display="none";
    p61.style.display="none";
    p71.style.display="none";
    P41.style.display="none";
      P51.style.display="none";
      P61.style.display="none";
      P71.style.display="none";
  if(numberMethod==1){
s1.style.display="block";
  }else if(numberMethod==2){
s2.style.display="block";
  }else if(numberMethod==3){
s3.style.display="block";
  }else if(numberMethod==4){
s4.style.display="block";
  }else if(numberMethod==5){
s5.style.display="block";
  }else if(numberMethod==6){
s6.style.display="block";
  }else if(numberMethod==7){
s7.style.display="block";
  }else if(numberMethod==8){
    s41.style.display="block";
      }else if(numberMethod==9){
    s51.style.display="block";
      }else if(numberMethod==10){
    s61.style.display="block";
      }else if(numberMethod==11){
    s71.style.display="block";
      }
}

//  Order Function


function OrderFun(numberMethod){

  p1.style.display="none";
  p2.style.display="none";
  p3.style.display="none";
  p4.style.display="none";
  p5.style.display="none";
  p6.style.display="none";
  p7.style.display="none";
  
  P1.style.display="none";
  P2.style.display="none";
  P3.style.display="none";
    P4.style.display="none";
    P5.style.display="none";
    P6.style.display="none";
    P7.style.display="none";
  
    s1.style.display="none";
    s2.style.display="none";
    s3.style.display="none";
      s4.style.display="none";
      s5.style.display="none";
      s6.style.display="none";
      s7.style.display="none";  
  
      c1.style.display="none";
      c2.style.display="none";
      
      o1.style.display="none";
      o2.style.display="none";
      o3.style.display="none";
        o4.style.display="none";
        o5.style.display="none";
        s41.style.display="none";
        s51.style.display="none";
        s61.style.display="none";
        s71.style.display="none";
        p41.style.display="none";
        p51.style.display="none";
        p61.style.display="none";
        p71.style.display="none";
        P41.style.display="none";
          P51.style.display="none";
          P61.style.display="none";
          P71.style.display="none";
        if(numberMethod==1){
          o1.style.display="block";
            }else if(numberMethod==2){
          o2.style.display="block";
            }else if(numberMethod==3){
          o3.style.display="block";
            }else if(numberMethod==4){
          o4.style.display="block";
            }else if(numberMethod==5){
          o5.style.display="block";
            }
    
  }





// Profile Function

function ProfileFun(numberMethod){

  p1.style.display="none";
  p2.style.display="none";
  p3.style.display="none";
  p4.style.display="none";
  p5.style.display="none";
  p6.style.display="none";
  p7.style.display="none";
  
  P1.style.display="none";
  P2.style.display="none";
  P3.style.display="none";
    P4.style.display="none";
    P5.style.display="none";
    P6.style.display="none";
    P7.style.display="none";
  
    s1.style.display="none";
    s2.style.display="none";
    s3.style.display="none";
      s4.style.display="none";
      s5.style.display="none";
      s6.style.display="none";
      s7.style.display="none";  
  
      o1.style.display="none";
      o2.style.display="none";
      o3.style.display="none";
        o4.style.display="none";
        o5.style.display="none";

      c1.style.display="none";
      c2.style.display="none";
      s41.style.display="none";
      s51.style.display="none";
      s61.style.display="none";
      s71.style.display="none";
      p41.style.display="none";
      p51.style.display="none";
      p61.style.display="none";
      p71.style.display="none";
      P41.style.display="none";
        P51.style.display="none";
        P61.style.display="none";
        P71.style.display="none";
    if(numberMethod==1){
  c1.style.display="block";
    }else if(numberMethod==2){
  c2.style.display="block";
    }
  }




function loggedIn(name){
  document.getElementById("loginId1").innerHTML=name;
  document.getElementById("loginId2").innerHTML=name;
  document.getElementById("l2").innerHTML="";
  document.getElementById("s2").innerHTML="";
  document.getElementById("l1").innerHTML="";
  document.getElementById("s1").innerHTML="";
}


document.getElementById("signupForm").addEventListener("submit",(event) =>{
  event.preventDefault();
  signupCustomer();
})
async function signupCustomer(){
  let form = document.getElementById("signupForm")
let obj={
  customerName:form.cName.value,
  customerEmail:form.cEmail.value,
  customerUsername:form.cUser.value,
  customerPassword:form.cPass.value,
  address:{
    houseNo:form.cHouse.value,
    colony:form.cColony.value,
    city:form.cCity.value,
    state:form.cState.value,
    pincode:form.cPin.value
  }
};
let data = fetch('http://localhost:8888/customer/register',{
  method:'POST',
  body:JSON.stringify(obj),
  headers:{
    'Content-Type':'application/json'
  }

})
console.log("Completed")
let res = await data;
if(res.ok){
  signupHide();
  alert("You Have Signed Up Successfully");
  form.reset(); 
}else{
  alert("Check Details");
}
}




document.getElementById("loginForm").addEventListener("submit",(event) =>{
  event.preventDefault();
  loginCustomer();
})
async function loginCustomer(){
  let form = document.getElementById("loginForm")
  let obj={};
  let user="";
  if(toggleU.textContent=="Admin"){
    user="admin"
    obj={
      adminUsername :form.LoginUserName.value,
      adminPassword:form.LoginUserPass.value
    }
  }else{
    user="customer";
    obj={
      customerUsername :form.LoginUserName.value,
      customerPassword:form.LoginUserPass.value
    }
  }
  let data = fetch(`http://localhost:8888/${user}/login`,{
    method:'PUT',
    body:JSON.stringify(obj),
    headers:{
      'Content-Type':'application/json'
    }
  })

  let res = await data;
  let serach=res.json()
  if(res.ok){
    loginHide();
document.getElementById("loginId1").textContent=form.LoginUserName.value;
document.getElementById("loginId2").textContent=form.LoginUserName.value;
document.getElementById("logout1").textContent="Logout";
document.getElementById("logout2").textContent="Logout";
document.getElementById("s1").style.display="none";
document.getElementById("l1").style.display="none";
document.getElementById("s2").style.display="none";
document.getElementById("l2").style.display="none";
    alert("You Have Logged In Successfully");
    form.reset(); 
  }else{
    alert("Check Details");
  }
  }

  function logout(){
    window.location.href="index.html"
    alert("Successfully Logged out");
  }