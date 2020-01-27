const mongoose = require('mongoose')



const PrimaryObjectSchema = mongoose.Schema({
    title: {type:String, required: [true, "This is a custom message"], minLength: [2, "The min length must be 2"]},
    description: String,
    url: String,
    ratings: [{
        rating: Number,
        review: String
    }]
},{timestamps:true})

mongoose.model('PrimaryObject', PrimaryObjectSchema)
