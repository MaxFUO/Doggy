using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class CambiarScena : MonoBehaviour
{

    private void Update()
    {
        
    }

    public void scenCargar(string nombreNivel)
    {
        SceneManager.LoadScene(nombreNivel);
    }
}
