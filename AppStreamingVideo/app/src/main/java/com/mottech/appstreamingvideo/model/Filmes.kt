import android.os.Parcel
import android.os.Parcelable

data class Filmes(
    val nomeFilme: String,
    val imagemFilme: Int, // ID da imagem no drawable
    val descricaoFilme: String,
    val linkFilme: String,
    val anoFilme: String,
    val elenco: List<String>
) : Parcelable {

    // Construtor usado para criar o objeto a partir de um Parcel
    constructor(parcel: Parcel) : this(
        parcel.readString()!!, // nomeFilme
        parcel.readInt(), // imagemFilme
        parcel.readString()!!, // descricaoFilme
        parcel.readString()!!, // linkFilme
        parcel.readString()!!, // anoFilme
        parcel.createStringArrayList()!! // elenco
    )

    // Escreve os dados do objeto no Parcel
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nomeFilme)
        parcel.writeInt(imagemFilme)
        parcel.writeString(descricaoFilme)
        parcel.writeString(linkFilme)
        parcel.writeString(anoFilme)
        parcel.writeStringList(elenco)
    }

    // Método obrigatório da interface Parcelable
    override fun describeContents(): Int {
        return 0
    }

    // Companion object para criar o objeto a partir de um Parcel
    companion object CREATOR : Parcelable.Creator<Filmes> {
        override fun createFromParcel(parcel: Parcel): Filmes {
            return Filmes(parcel)
        }

        override fun newArray(size: Int): Array<Filmes?> {
            return arrayOfNulls(size)
        }
    }
}