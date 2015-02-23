var electronicCategories = [{
    "_class": "com.myrotiuk.auction.model.category.Category",
    name: "phone"
}, {
    "_class": "com.myrotiuk.auction.model.category.Category",
    name: "computer"
}, {
    "_class": "com.myrotiuk.auction.model.category.Category",
    name: "tablet"
}, {
    "_class": "com.myrotiuk.auction.model.category.Category",
    name: "laptop"
}, {
    "_class": "com.myrotiuk.auction.model.category.Category",
    name: "camera"
}
];
var electronic = {
    "_class": "com.myrotiuk.auction.model.category.Category",
    "name": "electronic",
    "childrenCategories": []
};

function addCategories(categories, parent) {

    db.categories.insert(parent);
    var parentId = db.categories.findOne({"name": parent.name})._id;
    //print(parentId)

    for (var i in categories) {
        var category = categories[i];
        db.categories.insert(category);
        var categoryId = db.categories.findOne({"name": category.name})._id;
        var children  = db.categories.find({_id: parentId}, {childrenCategories:1, _id:0});
        print(children)
    }
    ;

}

addCategories(electronicCategories, electronic);