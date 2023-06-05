package com.nsicyber.biographyapp.fragments

import android.Manifest
import android.app.Dialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Context.CLIPBOARD_SERVICE
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.nsicyber.biographyapp.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ContactFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ContactFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var phoneNumber = "+905340770833"
    var mailString = "jcooligame@gmail.com"
    lateinit var phoneText: TextView
    lateinit var mailText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_contact, container, false)



        phoneText = view.findViewById(R.id.phoneText)
        mailText = view.findViewById(R.id.mailText)


        phoneText.text = phoneNumber
        mailText.text = mailString
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        phoneText.setOnClickListener {
            showPhoneAlertDialog(requireContext(), phoneNumber)

        }
        mailText.setOnClickListener {
            showMailAlertDialog(requireContext(), mailString)

        }


    }


    fun showPhoneAlertDialog(context: Context, message: String) {
        val customDialog = CustomAlertPhoneDialog(context, message) // Create custom dialog
        customDialog.setButtonClickListener { buttonNumber ->
            // Handle button click here
            when (buttonNumber) {
                1 -> {
                    if (ContextCompat.checkSelfPermission(
                            requireContext(), Manifest.permission.SEND_SMS
                        ) != PackageManager.PERMISSION_GRANTED
                    ) {
                        ActivityCompat.requestPermissions(
                            requireActivity(), arrayOf(Manifest.permission.SEND_SMS), 1
                        )
                    } else {
                        sendSMS(phoneNumber)
                    }
                }
                2 -> {
                    openWhatsApp(phoneNumber)

                }
                3 -> {
                    openCall(phoneNumber)


                }
                4 -> {
                    copyClip(phoneNumber)
                }
            }
        }
        customDialog.show() // Show dialog
    }

    fun showMailAlertDialog(context: Context, message: String) {
        val customDialog = CustomAlertMailDialog(context, message) // Create custom dialog
        customDialog.setButtonClickListener { buttonNumber ->
            // Handle button click here
            when (buttonNumber) {

                1 -> {
                    openMail(mailString)


                }
                2 -> {
                    copyClip(mailString)
                }
            }
        }
        customDialog.show() // Show dialog
    }


    fun copyClip(data: String) {

        val clipboard = requireContext().getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("Copied Text", data)
        clipboard.setPrimaryClip(clip)

    }

    private fun sendSMS(phoneNumber: String) {
        val smsIntent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("smsto:$phoneNumber")
        }
        if (smsIntent.resolveActivity(requireActivity().packageManager) != null) {
            startActivity(smsIntent)
        }
    }

    private fun openWhatsApp(smsNumber: String) {
        val sendIntent = Intent(Intent.ACTION_SEND)
        sendIntent.type = "text/plain"
        sendIntent.putExtra(
            Intent.EXTRA_TEXT, "Merhaba, bir ilan için yazmıştım "
        )
        val url = "https://wa.me/" + smsNumber
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)

    }

    fun openMail(mail: String) {


        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:" + mail)
        intent.putExtra(Intent.EXTRA_EMAIL, mail)
        intent.putExtra(Intent.EXTRA_SUBJECT, "Campus uygulamasındaki ilan")

        startActivity(Intent.createChooser(intent, "Email via..."))

    }

    fun openCall(data: String) {

        val intent = Intent(Intent.ACTION_DIAL);
        intent.data = Uri.parse("tel:$data")
        startActivity(intent)

    }

}


class CustomAlertPhoneDialog(context: Context, message: String) : Dialog(context) {
    private var listener: ((Int) -> Unit)? = null // Listener for button clicks

    init {
        requestWindowFeature(Window.FEATURE_NO_TITLE) // Remove title bar
        setContentView(R.layout.custom_alert_phone) // Set custom layout

        // Set click listeners for buttons
        findViewById<TextView>(R.id.textView).text = message

        findViewById<Button>(R.id.smsButton).setOnClickListener { handleButtonClick(1) }
        findViewById<Button>(R.id.whatsappButton).setOnClickListener { handleButtonClick(2) }
        findViewById<Button>(R.id.callButton).setOnClickListener { handleButtonClick(3) }
        findViewById<Button>(R.id.clipboardButton).setOnClickListener { handleButtonClick(4) }
    }

    // Method to set listener for button clicks
    fun setButtonClickListener(listener: (Int) -> Unit) {
        this.listener = listener
    }

    // Method to handle button clicks
    private fun handleButtonClick(buttonNumber: Int) {
        listener?.invoke(buttonNumber) // Invoke listener with button number
        dismiss() // Close dialog
    }
}

class CustomAlertMailDialog(context: Context, message: String) : Dialog(context) {
    private var listener: ((Int) -> Unit)? = null // Listener for button clicks

    init {
        requestWindowFeature(Window.FEATURE_NO_TITLE) // Remove title bar
        setContentView(R.layout.custom_alert_mail) // Set custom layout

        // Set click listeners for buttons
        findViewById<TextView>(R.id.textView).text = message

        findViewById<Button>(R.id.mailButton).setOnClickListener { handleButtonClick(1) }
        findViewById<Button>(R.id.clipboardButton).setOnClickListener { handleButtonClick(2) }
    }

    // Method to set listener for button clicks
    fun setButtonClickListener(listener: (Int) -> Unit) {
        this.listener = listener
    }

    // Method to handle button clicks
    private fun handleButtonClick(buttonNumber: Int) {
        listener?.invoke(buttonNumber) // Invoke listener with button number
        dismiss() // Close dialog
    }
}

