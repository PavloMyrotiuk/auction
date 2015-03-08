var products = [
        {
            "_class": "com.myrotiuk.auction.common.core.model.product.Product",
            "version": NumberLong(0),
            "addedDate": ISODate("2014-03-01T00:00:00.000Z"),
            "validDate":ISODate("2015-03-01T00:00:00.000Z"),
            "price": "300.99",
            "title": "Brand new iPhone 5C",
            "description": "It is one of two successors to the iPhone 5 and one of two predecessors to the iPhone 6," +
            " along with its higher-end counterpart, the iPhone 5S. Apple held an event to formally introduce the iPhone 5C " +
            "and 5S on September 10, 2013, and they were released on September 20, 2013,[2] therefore discontinuing sales of " +
            "the previous iPhone 5, although it was the first iPhone to be released to GSM carriers such as T-Mobile since " +
            "the iPhone 4.",
            "productStatus": "VALID",
            "category": "phone",
            "owner": {"$ref": "users", "$id": db.users.findOne({name: "a"})._id}
        }
    ];

function addProducts(products){
    for (var product in products){
        db.products.insert(products[product]);
    }
}

addProducts(products);