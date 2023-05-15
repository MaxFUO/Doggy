using System.Collections;
using System.Collections.Generic;
using UnityEditor;
using UnityEditor.SceneManagement;
using UnityEngine;
using UnityEngine.Events;
using UnityEngine.SceneManagement;
using UnityEngine.UI;
using UnityEngine.UIElements;

public class GameManager : MonoBehaviour
{
    public enum EstadosdelJuego { INICIO, TIENDA, ADOPTAR, COMIDA, BAÑO, COMUNIDAD, RANKING, ROPA, PLAY }
    public EstadosdelJuego estado;

    public GameObject player;

    public Text txtNombreAnimal;

    public void scenCargar(string nombreNivel)
    {
        SceneManager.LoadScene(nombreNivel);
    }

    public void enviarPlayer(string nombreNivel)
    {
        PrefabUtility.SaveAsPrefabAsset(player, "Assets/Prefabs/Player.prefab");
        SceneManager.LoadScene(nombreNivel);
    }
}
