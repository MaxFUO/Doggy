using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.Events;
using UnityEngine.SceneManagement;
using UnityEngine.UI;
using UnityEngine.UIElements;

public class GameManager : MonoBehaviour
{
    public enum EstadosdelJuego { INICIO, TIENDA, ADOPTAR, COMIDA, BAÑO, COMUNIDAD, RANKING, PLAY }
    public EstadosdelJuego estado;

    public GameObject gamPlayer;

    public Text txtNombreAnimal;

    void Start()
    {
        estado = EstadosdelJuego.INICIO;
    }

    
    void Update()
    {
        switch (estado)
        {
            case EstadosdelJuego.INICIO:
                gamPlayer.SetActive(true);
                
                break;
            default:
                break;
        }
    }
    public void scenCargar(string nombreNivel)
    {
        SceneManager.LoadScene(nombreNivel);
    }
}
