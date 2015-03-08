var electronicCategories = [{
    "_class": "com.myrotiuk.auction.common.core.model.category.Category",
    name: "phone"
}, {
    "_class": "com.myrotiuk.auction.common.core.model.category.Category",
    name: "computer"
}, {
    "_class": "com.myrotiuk.auction.common.core.model.category.Category",
    name: "tablet"
}, {
    "_class": "com.myrotiuk.auction.common.core.model.category.Category",
    name: "laptop"
}, {
    "_class": "com.myrotiuk.auction.common.core.model.category.Category",
    name: "camera"
}
];
var electronic = {
    "_class": "com.myrotiuk.auction.common.core.model.category.Category",
    "name": "electronic",
    "childrenCategories": []
};

var sportCategories = [{
    "_class": "com.myrotiuk.auction.common.core.model.category.Category",
    name: "bicycle"
}, {
    "_class": "com.myrotiuk.auction.common.core.model.category.Category",
    name: "basketball"
}, {
    "_class": "com.myrotiuk.auction.common.core.model.category.Category",
    name: "ski"
}, {
    "_class": "com.myrotiuk.auction.common.core.model.category.Category",
    name: "bobsleigh"
}, {
    "_class": "com.myrotiuk.auction.common.core.model.category.Category",
    name: "surfing"
}
];
var sport = {
    "_class": "com.myrotiuk.auction.common.core.model.category.Category",
    "name": "sport",
    "childrenCategories": []
};

function addCategories(categories, parent) {

    db.categories.insert(parent);
    var parentId = db.categories.findOne({"name": parent.name})._id;

    for (var i in categories) {
        var category = categories[i];
        db.categories.insert(category);

        var categoryId = db.categories.findOne({"name": category.name})._id;
        var child = new ObjectId(""+categoryId);
        db.categories.update({"_id": parentId}, {$addToSet:{childrenCategories:{"$ref": "categories", "$id": child}}});
    };

}

addCategories(electronicCategories, electronic);
addCategories(sportCategories, sport);