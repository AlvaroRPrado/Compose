package com.prado.faribase.base

class Constants {

    companion object{
        const val TITLE_KEY = "title_key"
        const val DESCRIPTION_KEY = "description_key"
        const val TITLE = "Titulo"
        const val CONTENT = "Decrição"
        const val TASK_KEY  = "task_key"
        const val NO_TASK_SAVED = "Não tem nenhuma tarefa salva!"
    }
    object ALERTDIALOG{
        const val YES = "Sim"
        const val NO = "Não"
        const val CONFIRMA_DELETE  = "Deseja excluir essa tarefa?"
    }

    object TOPAPPBARHEADER{
        const val CREATE_TASK= "Criar Nota"
        const val MY_TASK = "Minhas Notas"
        const val TASK_DETAIL="Detalhe da Nota"
        const val TASK_EDIT = "Editar Nota"


    }
    object ROUTES{
        const val TASKADDROUTE = "taskCreate"
        const val TASKAEDITROUTE = "taskEdit"
        const val TASKLISTROUTE = "taskList"
        const val TASKADETEILROUTE = "taskDetail"
    }
    object DATABASE{
        const val SHEREDPREFERENCE ="localdata"
        const val DATABASENAME = "task_database"
        const val TITLECOLUMN = "title"
        const val CONTENTCOLUNN = "content"

    }
}
