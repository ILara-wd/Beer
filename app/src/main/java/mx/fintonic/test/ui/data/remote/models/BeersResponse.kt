package mx.fintonic.test.ui.data.remote.models

import com.google.gson.annotations.SerializedName

class BeersResponse(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("tagline")
    var tagline: String? = null,
    @SerializedName("first_brewed")
    var firstBrewed: String? = null,
    @SerializedName("description")
    var description: String? = null,
    @SerializedName("image_url")
    var imageUrl: String? = null,
    @SerializedName("abv")
    var abv: Double? = null,
    @SerializedName("ibu")
    var ibu: Double? = null,
    @SerializedName("target_fg")
    var targetFg: Double? = null,
    @SerializedName("target_og")
    var targetOg: Double? = null,
    @SerializedName("ebc")
    var ebc: Double? = null,
    @SerializedName("srm")
    var srm: Double? = null,
    @SerializedName("ph")
    var ph: Double? = null,
    @SerializedName("attenuation_level")
    var attenuationLevel: Double? = null,
    @SerializedName("volume")
    var volume: Volume? = null,
    @SerializedName("boil_volume")
    var boilVolume: BoilVolume? = null,
    @SerializedName("method")
    var method: Method? = null,
    @SerializedName("ingredients")
    var ingredients: Ingredients? = null,
    @SerializedName("food_pairing")
    var foodPairing: List<String>? = null,
    @SerializedName("brewers_tips")
    var brewersTips: String? = null,
    @SerializedName("contributed_by")
    var contributedBy: String? = null
)

class Amount(
    @SerializedName("value")
    var value: Double? = null,
    @SerializedName("unit")
    var unit: String? = null
)

data class BoilVolume(
    @SerializedName("value")
    var value: Double? = null,
    @SerializedName("unit")
    var unit: String? = null
)

data class Volume(
    @SerializedName("value")
    var value: Double? = null,
    @SerializedName("unit")
    var unit: String? = null
)

data class Fermentation(
    @SerializedName("temp")
    var temp: Temp? = null
)

data class Hop(
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("amount")
    var amount: Amount? = null,
    @SerializedName("add")
    var add: String? = null,
    @SerializedName("attribute")
    var attribute: String? = null
)

data class Ingredients(
    @SerializedName("malt")
    var malt: List<Malt>? = null,
    @SerializedName("hops")
    var hops: List<Hop>? = null,
    @SerializedName("yeast")
    var yeast: String? = null
)

data class Malt(
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("amount")
    var amount: Amount? = null
)

data class MashTemp(
    @SerializedName("temp")
    var temp: Temp? = null,
    @SerializedName("duration")
    var duration: Double? = null
)

data class Method(
    @SerializedName("mash_temp")
    var mashTemp: List<MashTemp>? = null,
    @SerializedName("fermentation")
    var fermentation: Fermentation? = null,
    @SerializedName("twist")
    var twist: String? = null
)

data class Temp(
    @SerializedName("value")
    var value: Double? = null,
    @SerializedName("unit")
    var unit: String? = null,
)