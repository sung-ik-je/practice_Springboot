
const ca = {
  add : function (x, y) {
    return x + y;
  }
}

const a = ca.add(1, 4);
console.log(isNaN(a));
console.log(typeof(a));


const age = 100;
console.log(age === 100)
console.log(age == 100)
console.log(age == '100')
console.log(age === '100')