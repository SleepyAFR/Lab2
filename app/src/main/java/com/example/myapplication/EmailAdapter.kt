package layout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Email
import com.example.myapplication.R


class EmailAdapter(private val emails: List<Email>) : RecyclerView.Adapter<EmailAdapter.ViewHolder>(){
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        // as you render a row.

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view

        val senderView: TextView
        val titleView: TextView
        val summaryView: TextView

        init {

            // the public final member variables created above

            senderView = itemView.findViewById(R.id.sender)
            titleView = itemView.findViewById(R.id.emailTitle)
            summaryView= itemView.findViewById(R.id.summary)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.email_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun getItemCount(): Int {

        return emails.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val email = emails.get(position)
        // Set item views based on views and data model
        holder.senderView.text = email.sender
        holder.titleView.text = email.title
        holder.summaryView.text = email.summary
    }

}
