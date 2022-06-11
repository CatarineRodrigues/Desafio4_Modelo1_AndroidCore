package br.com.zup.simcitysaojoao.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Produto (
        private var nome: String,
        private var quantidade: Int,
        private var valorUnitario: Double,
        private var receita: String
        ) : Parcelable {
                private var valorTotal = quantidade*valorUnitario

        fun getNome() = this.nome
        fun getQuantidade() = this.quantidade
        fun getValorUnit() = this.valorUnitario
        fun getReceita() = this.receita
        fun getValorTotal() = this.valorTotal
}