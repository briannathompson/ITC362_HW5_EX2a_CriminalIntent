package com.bignerdranch.android.criminalintent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.criminalintent.databinding.ListItemCrimeBinding

// 10.10 define a view holder by adding a CrimeHolder class that extends from RecyclerView.ViewHolder.
class CrimeHolder(
    val binding: ListItemCrimeBinding
    // pass the binding's root view as the arg to RecyclerView.ViewHolder()'s constructor
) : RecyclerView.ViewHolder(binding.root) { //the base class, ViewHolder, will hold onto the view in a property called itemView
}

// 10.11 Add a new class named CrimeListAdapter
// Add a primary constructor that expects a list of crimes as input and stores the passed-in crime list in a property
class CrimeListAdapter(
    private val crimes: List<Crime>
) : RecyclerView.Adapter<CrimeHolder>() {

// Override 3 functions: onCreateViewHolder(), onBindViewHolder(), getItemCount()

    /* Adapter.onCreateViewHolder(...) is responsible for:
    * 1. Creating a binding to display,
    * 2. Wrapping the view in a view holder, and
    * 3. Returning the result */
    override fun onCreateViewHolder(
        // ignore these parameters for now (parent & viewType)
        parent: ViewGroup,
        viewType: Int
    ) : CrimeHolder {
        /*In this case, we inflate and bind a ListItemCrimeBinding and
        pass the resulting binding to a new instance of CrimeHolder*/
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemCrimeBinding.inflate(inflater, parent, false)
        return CrimeHolder(binding)
    }
    /* Adapter.onBindViewHolder(…) is responsible for populating a
       given holder with the crime from a given position. */
    override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
        val crime = crimes[position]
        holder.apply {
            binding.crimeTitle.text = crime.title
            binding.crimeDate.text = crime.date.toString()
        }
    }
    /* Adapter.getItemCount() is called when the recycler view needs to
    * know how many items are in the data set backing it */
    override fun getItemCount() = crimes.size // returns the number of items in the list of crimes to answer the recycler view’s request.

}
