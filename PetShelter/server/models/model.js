const mongoose = require('mongoose')



const PrimaryObjectSchema = mongoose.Schema({
    name: {type:String, unique: [true, "Name MUST be unique"], required: [true, "Name is required"], minlength: [3, "The min length must be 3"]},
    type: {type: String, required: [true, "Type is required"], minlength: [3, "The min length must be 3"]},
    description: {type: String, required: [true, "Description is required"], minlength: [3, "The min length must be 3"]},
    likes: {type: Number},
    skills: [{
        skill: {type: String},
    }],
},{timestamps:true})

mongoose.model('PrimaryObject', PrimaryObjectSchema)
