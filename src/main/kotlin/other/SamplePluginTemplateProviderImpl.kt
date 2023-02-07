package other

import com.android.tools.idea.wizard.template.WizardTemplateProvider
import other.mvp.activity.mvpActivityTemplate
import other.mvp.fragment.mvpFragmentTemplate

class SamplePluginTemplateProviderImpl: WizardTemplateProvider() {
    override fun getTemplates() = listOf(
        mvpActivityTemplate,mvpFragmentTemplate
    )
}