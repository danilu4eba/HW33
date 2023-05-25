package layout

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.hw3.ImageModel
import com.example.hw3.databinding.ItemImageBinding

class PixAdapter(var list: ArrayList<ImageModel>) : Adapter<PixAdapter.PixViewHolder>() {
    class PixViewHolder(var binding: ItemImageBinding) : ViewHolder(binding.root) {

        fun onBind(imageModel: ImageModel) {
            binding.ivOne.load(imageModel.largeImageURL)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PixViewHolder {
        return PixViewHolder(
            ItemImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PixViewHolder, position: Int) {
        holder.onBind(list[position])
    }
}