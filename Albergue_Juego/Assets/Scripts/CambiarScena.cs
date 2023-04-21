using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class CambiarScena : MonoBehaviour
{
    public string nombreEscena;

    public void ChangeScene()
    {
        SceneManager.LoadScene(nombreEscena);
    }

    public void scenJuego()
    {
        SceneManager.LoadScene("MiniJuegos");
    }
    public void scenAdoptar()
    {
        SceneManager.LoadScene("Adoptar");
    }
    public void scenComida()
    {
        SceneManager.LoadScene("Comida");
    }
    public void scenBanar()
    {
        SceneManager.LoadScene("Bañar");
    }
    public void scenTienda()
    {
        SceneManager.LoadScene("Tienda");
    }
    public void scenComunidad()
    {
        SceneManager.LoadScene("Comunidad");
    }
    public void scenRanking()
    {
        SceneManager.LoadScene("Ranking");
    }
}
