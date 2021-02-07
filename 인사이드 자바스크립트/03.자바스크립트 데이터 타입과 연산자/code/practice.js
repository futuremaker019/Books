// str 문자열 생성
var str = 'test';
console.log(str[0], str[1], str[2], str[3]);

// 문자열의 첫 글자를 대문자로 변경이 가능?
str[0] = 'T';
console.log(str[0]);
console.log(str);

// Object()를 이용해서 foo 빈 객체 생성
var foo = new Object();

// foo 객체 프로퍼티 생성
foo.name = 'foo';
foo.age = 30;
foo.gender = 'male';

console.log(typeof foo);
console.log(foo);

// 객체 리터럴 방식으로 foo 객체 생성
var foo2 = {
  name: 'foo',
  age: 30,
  gender: 'male',
};

console.log(typeof foo);
console.log(foo);

// 갹체 리터럴 방식을 통한 foo 객체 생성
var foo3 = {
  name: 'foo',
  major: 'computer science',
};

// 객체 프로퍼티 읽기
console.log(foo.name);
console.log(foo['name']);

// 객체 프로퍼티 갱싱
var major = 'electronics engineering';
console.log(foo.major);
console.log(foo['major']);

// 객체 프로퍼티 동적 생성
foo.age = 30;
console.log(foo['age']);

// 대괄호 표기법만을 사용해야 할 경우
foo['full-name'] = 'foo bar';
console.log(foo['full-name']);
console.log(foo.full - name);

// 객체 리터럴을 통한 foo 객체 생성
var foo4 = {
  name: 'foo',
  age: 30,
  major: 'computer sience',
};

// for in 문을 이용한 객체 프로퍼티 출력
var prop;
for (prop in foo4) {
  console.log(prop, foo4[prop]);
}
