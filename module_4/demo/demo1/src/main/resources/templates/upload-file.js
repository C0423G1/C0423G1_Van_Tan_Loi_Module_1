import firebase from "./configuration-firebase.js"
function handleUpload(e) {
    console.dir(e);
    const ref = firebase.storage().ref();
    const files = e.target.files;
    const uploadedURLs = [];
    Array.from(files).forEach(file => {
        const name = +new Date() + "-" + file.name;
        const metadata = {
            contentType: file.type
        };
        const task = ref.child(name).put(file, metadata);

        task
            .then(snapshot => snapshot.ref.getDownloadURL())
            .then(url => {
                console.log(url);
                uploadedURLs.push(url);
                if (uploadedURLs.length === files.length) {
                    alert('Tất cả ảnh đã được tải lên thành công');
                    console.log(uploadedURLs);
                }
            })
            .catch(console.error);
    });
}
function handleClick() {
    document.getElementById("upload-file").addEventListener("change", function (e) {
        handleUpload(e)
    });
}
const button = document.getElementById('myButton');
button.addEventListener('click', ()=>{
    handleClick()
});

